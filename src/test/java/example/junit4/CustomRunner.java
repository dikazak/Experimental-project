package example.junit4;

import lombok.SneakyThrows;
import org.junit.AssumptionViolatedException;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;

public class CustomRunner extends Runner {

    private final Class<?> testClass;
    private final HashMap<Method, Description> methodDescriptions;

    public CustomRunner(Class<?> testClass) {
        this.testClass = testClass;
        methodDescriptions = new HashMap<>();
    }

    public Description getDescription() {
        Description description = Description.createSuiteDescription(testClass.getName(), testClass.getAnnotations());

        for (Method method : testClass.getMethods()) {
            Annotation annotation = method.getAnnotation(Test.class);

            if (annotation != null) {
                Description methodDescription = Description.createTestDescription(testClass, method.getName(), annotation);
                description.addChild(methodDescription);

                methodDescriptions.put(method, methodDescription);
            }
        }

        return description;
    }

    @Override
    public void run(RunNotifier runNotifier) {
        methodDescriptions.forEach((method, description) -> tryRunTest(runNotifier, method, description));
    }

    @SneakyThrows
    private void tryRunTest(RunNotifier runNotifier, Method method, Description description) {
        Object instance = testClass.getDeclaredConstructor().newInstance();

        try {
            runNotifier.fireTestStarted(description);

            method.invoke(instance);

            runNotifier.fireTestFinished(description);
        } catch (AssumptionViolatedException e) {
            Failure failure = new Failure(description, e.getCause());
            runNotifier.fireTestAssumptionFailed(failure);
        } catch (Throwable e) {
            Failure failure = new Failure(description, e.getCause());
            runNotifier.fireTestFailure(failure);
        } finally {
            runNotifier.fireTestFinished(description);
        }
    }

}

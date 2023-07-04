package example.testng;

import org.testng.annotations.Test;

public class GroupSample {

    @Test(dependsOnGroups = "G2")
    public void t9() {
    }

}

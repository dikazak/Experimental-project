package example.testng;

import org.testng.annotations.Test;

public class GroupSample2 {

    @Test(groups = {"G3", "G4", "G5"}, dependsOnGroups = {"G1", "G2"})
    public void t1() {
    }

    @Test(groups = {"G3", "G4", "G5"}, dependsOnGroups = {"G1", "G2"})
    public void t2() {
    }

    @Test(groups = {"G3", "G4", "G5"}, dependsOnGroups = {"G1", "G2"})
    public void t3() {
    }

    @Test(groups = "G5", dependsOnGroups = "G2")
    public void t4() {
    }

    @Test(groups = "G5", dependsOnGroups = "G2")
    public void t5() {
    }

    @Test(groups = "G3", dependsOnGroups = "G1")
    public void t6() {
    }

    @Test(groups = "G1")
    public void t7() {
    }

    @Test(groups = "G2")
    public void t8() {
    }

    @Test(groups = "G2")
    public void t9() {
    }

}

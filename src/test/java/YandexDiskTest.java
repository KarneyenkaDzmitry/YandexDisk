import com.epam.ta.steps.Steps;
import com.epam.ta.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YandexDiskTest {
    private Steps steps = new Steps();

    private final String LOGIN = "dzmitry.karneyenka";
    private final String PASSWORD = "testpassword";

    @BeforeClass(description = "Init browser")
    public void beforeClass() {
        steps = new Steps();
        steps.initBrowser();
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }

    @Test
    public void testCreateNewDisk() {
        Assert.assertTrue(steps.createNewDiskButton());
    }

    @Test(dependsOnMethods = "testCreateNewDisk")
    public void canLogIn() {
        Assert.assertTrue(steps.loginYandexDisk(LOGIN, PASSWORD));
    }

    @Test(dependsOnMethods = "canLogIn")
    public void createNewFolder() {
        String name = "folder#" + Utils.getRandomString(5);
        Assert.assertTrue(steps.createNewFolder(name), "message");
    }

    @Test(dependsOnMethods = "createNewFolder")
    public void canSelectSomeFilesAndRemoveThemIntoFolder() {
        steps.deleteFirstXFilesWithMouse(3);
    }

    @Test(dependsOnMethods = "canSelectSomeFilesAndRemoveThemIntoFolder")
    public void canLogOut() {
        Assert.assertTrue(steps.logOutYandexDisk(), "message");
    }

    @Test(dependsOnMethods = "canLogOut")
    public void jsExecutorTest() {
        Assert.assertTrue(steps.runJSExecutor());
    }
}

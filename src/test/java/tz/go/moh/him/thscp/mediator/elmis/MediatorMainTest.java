package tz.go.moh.him.thscp.mediator.elmis;

import org.junit.Assert;
import org.junit.Test;
import org.openhim.mediator.engine.MediatorConfig;

import java.lang.reflect.Method;

/**
 * Contains tests for the {@link MediatorMain} class.
 */
public class MediatorMainTest {

    /**
     * Test the mediator main class loading the configuration.
     *
     * @throws Exception
     */
    @Test
    public void mediatorMainTest() throws Exception {

        Method loadConfigMethod = MediatorMain.class.getDeclaredMethod("loadConfig", String.class);

        loadConfigMethod.setAccessible(true);
        MediatorConfig mediatorConfig = (MediatorConfig) loadConfigMethod.invoke(null, "src/test/resources/mediator.properties");

        Assert.assertEquals("localhost", mediatorConfig.getServerHost());
        Assert.assertEquals(Integer.valueOf(3017), mediatorConfig.getServerPort());
        Assert.assertEquals(Integer.valueOf(60000), mediatorConfig.getRootTimeout());
        Assert.assertTrue(mediatorConfig.getHeartsbeatEnabled());
    }

}
package eu.jaimefreire.fix;

import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by jaimefreire on 30/07/2016.
 */
public class StrongPassTest {
    @org.junit.Test
    public void generatePasswordTest() throws Exception {
        Assert.assertNotNull(StrongPass.generatePassword(),"Password should not be null");
    }

}
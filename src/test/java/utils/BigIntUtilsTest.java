package utils;

import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.Assert.assertTrue;

public class BigIntUtilsTest {
    @Test
    public void testSumOfDigits() throws Exception {

        assertTrue(utils.BigIntUtils.sumOfDigits(new BigInteger("32768")).equals(new BigInteger("26")));


    }
}

package com.example.javaclockbackend.unittest;

import com.example.javaclockbackend.controller.utils.SecurityUtils;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class UtilsTest {

    @Test
    public void testMD5Hash() {
        final String password = "NhatKhoi123!";
        String hashedCodeExpected = "c348a39b07eaf44e354d4c609cad5b43";
        hashedCodeExpected = hashedCodeExpected.toUpperCase();

        assertThat(SecurityUtils.hashPassword(password)).isEqualTo(hashedCodeExpected);
    }
}

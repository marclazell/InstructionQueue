package com.tp.test;

import com.tp.exception.InvalidMessageException;
import com.tp.pojo.InstructionMessage;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;

/**
 * Created by dev on 21/05/15.
 */
public class InstructionMessageTest extends TestCase {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    private InstructionMessage im = new InstructionMessage();

    private static Integer VALID_INSTRUCTION_TYPE = 75;
    private static Integer VALID_PRODUCT_CODE = 9999;
    private static Integer VALID_QUANTITY = 500;
    private static Integer VALID_UOM = 150;
    private static Integer VALID_TIMESTAMP = 50;

    private static Integer INVALID_INSTRUCTION_TYPE_LOW = -10;
    private static Integer INVALID_INSTRUCTION_TYPE_HIGH = 105;
    private static Integer INVALID_PRODUCT_CODE = -1;
    private static Integer INVALID_QUANTITY = -1;
    private static Integer INVALID_UOM_LOW = -1;
    private static Integer INVALID_UOM_HIGH = 300;
    private static Integer INVALID_TIMESTAMP = -1;


    protected void setUp() throws Exception {
        super.setUp();
        im = new InstructionMessage();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }


    public void testInstructionTypeValid() {
        instructionMessageValid();
        instructionTypeInvalidLow();
        instructionTypeInvalidHigh();
        productCodeInvalid();
        quantityInvalid();
        uomInvalidLow();
        uomInvalidHigh();
        timestampInvalid();
    }

    @Test
    public void instructionMessageValid() {
        try {
            im.setInstructionType(VALID_INSTRUCTION_TYPE);
            im.setProductCode(VALID_PRODUCT_CODE);
            im.setQuantity(VALID_QUANTITY);
            im.setUOM(VALID_UOM);
            im.setTimeStamp(VALID_TIMESTAMP);
            assertEquals(im.isInstructionMessageValid(), true);

        } catch (InvalidMessageException e) {
            fail("An InvalidMessageException was thrown");
        }
    }

    @Test
    public void instructionTypeInvalidLow() {
        try {
            im.setInstructionType(INVALID_INSTRUCTION_TYPE_LOW);
            im.setProductCode(VALID_PRODUCT_CODE);
            im.setQuantity(VALID_QUANTITY);
            im.setUOM(VALID_UOM);
            im.setTimeStamp(VALID_TIMESTAMP);
            im.isInstructionMessageValid();
            fail("Expected an InvalidMessageException to be thrown");
        } catch (InvalidMessageException e) {
            assertThat(e, isA(InvalidMessageException.class));
        }
    }

    @Test
    public void instructionTypeInvalidHigh() {
        try {
            im.setInstructionType(INVALID_INSTRUCTION_TYPE_HIGH);
            im.setProductCode(VALID_PRODUCT_CODE);
            im.setQuantity(VALID_QUANTITY);
            im.setUOM(VALID_UOM);
            im.setTimeStamp(VALID_TIMESTAMP);
            im.isInstructionMessageValid();
            fail("Expected an InvalidMessageException to be thrown");
        } catch (InvalidMessageException e) {
            assertThat(e, isA(InvalidMessageException.class));
        }

    }

    @Test
    public void productCodeInvalid() {
        try {
            im.setInstructionType(VALID_INSTRUCTION_TYPE);
            im.setProductCode(INVALID_PRODUCT_CODE);
            im.setQuantity(VALID_QUANTITY);
            im.setUOM(VALID_UOM);
            im.setTimeStamp(VALID_TIMESTAMP);
            im.isInstructionMessageValid();
            fail("Expected an InvalidMessageException to be thrown");
        } catch (InvalidMessageException e) {
            assertThat(e, isA(InvalidMessageException.class));
        }
    }

    @Test
    public void quantityInvalid() {
        try {
            im.setInstructionType(VALID_INSTRUCTION_TYPE);
            im.setProductCode(VALID_PRODUCT_CODE);
            im.setQuantity(INVALID_QUANTITY);
            im.setUOM(VALID_UOM);
            im.setTimeStamp(VALID_TIMESTAMP);
            im.isInstructionMessageValid();
            fail("Expected an InvalidMessageException to be thrown");
        } catch (InvalidMessageException e) {
            assertThat(e, isA(InvalidMessageException.class));
        }
    }

    @Test
    public void uomInvalidLow() {
        try {
            im.setInstructionType(VALID_INSTRUCTION_TYPE);
            im.setProductCode(VALID_PRODUCT_CODE);
            im.setQuantity(VALID_QUANTITY);
            im.setUOM(INVALID_UOM_LOW);
            im.setTimeStamp(VALID_TIMESTAMP);
            im.isInstructionMessageValid();
            fail("Expected an InvalidMessageException to be thrown");
        } catch (InvalidMessageException e) {
            assertThat(e, isA(InvalidMessageException.class));
        }
    }

    @Test
    public void uomInvalidHigh() {
        try {
            im.setInstructionType(VALID_INSTRUCTION_TYPE);
            im.setProductCode(VALID_PRODUCT_CODE);
            im.setQuantity(VALID_QUANTITY);
            im.setUOM(INVALID_UOM_HIGH);
            im.setTimeStamp(VALID_TIMESTAMP);
            im.isInstructionMessageValid();
            fail("Expected an InvalidMessageException to be thrown");
        } catch (InvalidMessageException e) {
            assertThat(e, isA(InvalidMessageException.class));
        }
    }

    @Test
    public void timestampInvalid() {
        try {
            im.setInstructionType(VALID_INSTRUCTION_TYPE);
            im.setProductCode(VALID_PRODUCT_CODE);
            im.setQuantity(VALID_QUANTITY);
            im.setUOM(VALID_UOM);
            im.setTimeStamp(INVALID_TIMESTAMP);
            im.isInstructionMessageValid();
            fail("Expected an InvalidMessageException to be thrown");
        } catch (InvalidMessageException e) {
            assertThat(e, isA(InvalidMessageException.class));
        }
    }
}

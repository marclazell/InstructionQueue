package com.tp.run;

import com.tp.exception.InvalidMessageException;
import com.tp.pojo.InstructionMessage;
import com.tp.pojo.InstructionQueue;
import com.tp.util.BooleanUtil;

/**
 * Created by dev on 21/05/15.
 */
public class InstructionQueueMain {

    private static InstructionQueue instructionQueue = new InstructionQueue();

    static BooleanUtil booleanUtil = new BooleanUtil();

    public static void main(String[] args) throws InvalidMessageException {

        for (int i = 0; i < 10; i++) {
            Integer instructionType = (int) (Math.random() * 99);
            Integer productCode = (int) (Math.random() * 100000);
            Integer quantity = (int) (Math.random() * 5000);
            Integer uom = (int) (Math.random() * 255);
            Integer timestamp = (int) (Math.random() * 500);

            InstructionMessage im = new InstructionMessage(instructionType, productCode, quantity, uom, timestamp);

            // check valid first - throw exception if not
            if (im.isInstructionMessageValid()) {
                instructionQueue.addToList(im);
            }

        }

        // show all instructions and show sorting

        System.out.println("----------------------------------");
        System.out.println("All instruction messages");
        printQueue();

        System.out.println("----------------------------------");
        System.out.println("First instruction message");
        System.out.println((!instructionQueue.isInstructionQueueEmpty()) ? instructionQueue.getFirstMessage().toString() : "Queue is empty");

        System.out.println("----------------------------------");
        System.out.println("Instruction Queue Size");
        System.out.println(instructionQueue.getInstructionQueueSize());

        System.out.println("----------------------------------");
        instructionQueue.removeFromList(5);
        System.out.println("Removed a message (size is now " + instructionQueue.getInstructionQueueSize() + ")");
        printQueue();

        System.out.println("----------------------------------");
        System.out.println("Is the queue empty");
        System.out.println(booleanUtil.booleanToYesNoConvertor(instructionQueue.isInstructionQueueEmpty()));




    }

    public static void printQueue() {
        for (InstructionMessage i : instructionQueue.getInstructionQueue()) {
            System.out.println(i.toString());
        }
    }
}

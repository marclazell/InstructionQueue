package com.tp.pojo;

import java.util.ArrayList;

/**
 * Created by dev on 21/05/15.
 */
public class InstructionQueue {

    public ArrayList<InstructionMessage> instructionQueue = new ArrayList<InstructionMessage>();

    public ArrayList<InstructionMessage> getInstructionQueue() {
        return instructionQueue;
    }

    public void setInstructionQueue(ArrayList<InstructionMessage> instructionQueue) {
        this.instructionQueue = instructionQueue;
    }

    public void addToList(InstructionMessage im) {
        this.getInstructionQueue().add(im);
    }

    public void removeFromList(InstructionMessage im) {
        this.getInstructionQueue().remove(im);
    }

    public void removeFromList(int index) {
        this.getInstructionQueue().remove(index);
    }

    @Override
    public String toString() {
        return "InstructionQueue{" +
                "instructionQueue=" + instructionQueue +
                '}';
    }


}

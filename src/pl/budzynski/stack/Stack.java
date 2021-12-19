package pl.budzynski.stack;

import java.util.Deque;
import java.util.EmptyStackException;

/**
 * Class represents my representation of Stack. The usual
 * push and pop operations are provided.
 * Method peekMin shows minimum value on the stack.
 * That is why Elements have to extend Comparable.
 * When a stack is first created, it contains no items.
 * As required stacks methods don't use iteration.
 *
 * @author  Wojciech Budzyński
 */
public class Stack<E extends Comparable>
{
    /**
     * StackElement is kept on the stack. It contains:
     * element-stored item
     * under-element under it. If it is null this is bottom item.
     * previousMin-element that was previous minimal value. If it is null element never will be minimum.
     */
    class StackElement{
        /**
         * Stored item.
         */
        E element;
        /**
         * Previous minimal value.
         */
        StackElement previousMin;
        /**
         * Element under it.
         */
        StackElement under;
        /**
         * Creates StackElement.
         */
        StackElement(E element,StackElement previousMin,StackElement under){
            this.element=element;
            this.previousMin=previousMin;
            this.under=under;
        }
    }
    /**
     * Top of the stack.
     */
    private StackElement top;
    /**
     * Min value of the stack.
     */
    private StackElement min;
    /**
     * Pushes an item onto the top of this stack.
     * If new item is min. Set it as new min.
     *
     * @param   element   the item to be pushed onto this stack.
     */
    public void push(E element) {
        if (empty()) {
            top=new StackElement(element,null,null);
            min=top;
        }else if(element.compareTo(min.element)<0) {
            top= new StackElement(element,min,top);
            min=top;
        }else {
            top= new StackElement(element,null,top);
        }

    }
    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function. If the object was min.
     * Sets new min.
     *
     * @return  The object at the top of this stack.
     * @throws EmptyStackException  if this stack is empty.
     */
    public E pop() throws EmptyStackException {
        if (empty()) {
            throw new EmptyStackException();
        }
        E popped=top.element;
        if(min.equals(top)){
            min=min.previousMin;
        }
        top=top.under;

        return popped;
    }
    /**
     * Looks at the min object of this stack without removing it
     * from the stack.
     *
     * @return  the min object of this stack.
     * @throws  EmptyStackException  if this stack is empty.
     */
    public E peekMin() throws EmptyStackException {
        if (empty()) {
            throw new EmptyStackException();
        }
        return min.element;
    }
    /**
     * Tests if this stack is empty.
     *
     * @return  true if contains no items.
     */
    public boolean empty() {
        return top==null;
    }
/*
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:\n");
        sb.append("Min: ");
        sb.append(min.element.toString());
        sb.append("\n");
        sb.append("--------\n");
        StackElement iterator=top;
        while(iterator!=null) {
            sb.append(iterator.element.toString());
            sb.append(" previous ");
            if(iterator.previousMin!=null)
                sb.append(iterator.previousMin.element.toString());
            else
                sb.append("null");
            sb.append("\n");
            iterator=iterator.under;

        }
        sb.append("--------");
        return sb.toString();
    }
*/
}

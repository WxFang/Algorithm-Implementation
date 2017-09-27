class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> st = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public  MinStack(){
        this.st = st;
        this.min = min;
    }

    public void push(int x){
        st.push(x);
        if(min.isEmpty() == true || x < min.peek())
            min.push(x);
        else
            min.push(min.peek());
    }

    public void pop(){
        st.pop();
        min.pop();
    }

    public int top(){
        return st.peek();
    }

    public int getMin(){
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
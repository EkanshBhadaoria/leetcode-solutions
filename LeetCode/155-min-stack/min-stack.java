// Approach 1
// Using extra space
// class MinStack {
//     Stack<Integer> st = new Stack<>();
//     Stack<Integer> min = new Stack<>();  // extra space
//     public MinStack() {
        
//     }
    
//     public void push(int val) {
//         if(st.size() == 0) {
//             st.push(val);
//             min.push(val);
//         } else {
//             st.push(val);
//             if(min.peek() < val) min.push(min.peek());
//             else min.push(val);
//         }
//     }
    
//     public void pop() {
//         st.pop();
//         min.pop();
//     }
    
//     public int top() {
//         return st.peek();
//     }
    
//     public int getMin() {
//         return min.peek();
//     }
// }

// Approach 2
// without using extra space
class MinStack {
    Stack<Long> st = new Stack<>();
    long min;
    public MinStack() {

    }

    public void push(int val) {
        if(st.size() == 0) {
            st.push((long)val);
            min = val;
        } else {
            if(val < min) {
                st.push(2L * val - min);
                min = val;
            } else {
                st.push((long)val);
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) return;
        if(st.peek() >= min) st.pop();
        else {
            min = 2 * min - st.pop();
        }
    }

    public int top() {
        if(st.peek() < min) return (int)min;
        return st.peek().intValue();
    }

    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
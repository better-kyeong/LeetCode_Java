class MyQueue {
    //삽입용
    Deque<Integer> input = new ArrayDeque<>();
    //추출용
    Deque<Integer> output = new ArrayDeque<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        //삽입은 삽입 스택에 단순 추가
        input.push(x);
    }
    
    public int pop() {
        //추출 스택 조회하면서 비어있다면 처리 진행
        peek();
        //추출 스택에 있는 마지막 값 추출
        return output.pop();
    }
    
    public int peek() {
        //추출 스택에 저장된 게 없다면 진행
        if (output.isEmpty()) {
            //삽입 스택이 비워질 때까지 진행
            while (!input.isEmpty()) {
                //삽입 스택에서 추출한 결과를 추출 스택에 삽입(역순 저장)
                output.push(input.pop());
            }
        }
        //가장 나중에 삽입된 결과 조회
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
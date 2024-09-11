package DataStructure.힙;

import java.util.Random;

//Min Heap
public class HeapExample {
    public static void main(String[] args) {
        Random random = new Random();
        Heap heap = new Heap(10);

        for(int i=1; i<=11; i++) heap.add(random.nextInt(100));

        for(int i=1; i<=11; i++) System.out.println(heap.poll());
    }
}

class Heap{
    int[] arr;
    int size;
    int capacity;

    Heap(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity+1];
        this.size = 0;
    }

    public void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void add(int num){
        if(capacity == size) return;

        size++;
        int index = size;
        arr[index] = num;

        while(index/2 > 0){
            if(arr[index] < arr[index/2]){
                swap(index,index/2);
                index /= 2;
            }else{
                break;
            }
        }
    }

    public int poll(){
        // 비었을 때, return -1
        if(size==0) return -1;

        int root = arr[1];

        arr[1] = arr[size];
        size--;
        int index = 1;

        while(index*2 <= size){ //자식 노드가 있을때
            int leftChild = index*2;
            int rightChild = leftChild+1;
            int smallerChild = rightChild<=size && arr[rightChild] < arr[leftChild] ? rightChild : leftChild;

            if(arr[index] > arr[smallerChild]){
                swap(index,smallerChild);
                index = smallerChild;
            }else{
                break;
            }
        }

        return root;
    }
}

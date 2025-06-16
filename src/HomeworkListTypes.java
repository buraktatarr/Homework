
import java.util.Arrays;

public class HomeworkListTypes<T> {
        Object[] dizim;
        int capacity;
        int size;

        public HomeworkListTypes(int capacity) {
            this.capacity = capacity;
            size = 0;
            dizim = new Object[capacity];
        }

        public HomeworkListTypes() {
            this.capacity = 10;
            size = 0;
            dizim = new Object[capacity];
        }

        public int size() {
            return this.size;
        }

        public int getCapacity() {
            return this.capacity;
        }

        public void add(T data) {

            if (size == capacity) {

                capacity *= 2;
                Object[] yeniDizim = new Object[capacity];
                for (int i = 0; i < dizim.length; i++) {
                    yeniDizim[i] = dizim[i];
                }
                this.dizim = yeniDizim;
            }
            dizim[size] = data;
            size++;
        }

        @SuppressWarnings("unchecked")
        public T get(int index) {

            if (index >= 0 && index < size) {
                return (T) dizim[index];

            } else {

                return null;
            }

        }

        @SuppressWarnings("unchecked")
        public T remove(int index) {
            if (index >= 0 && index < size) {
                T silinen = (T) dizim[index];

                // Elemanları sola kaydır
                for (int i = index; i < size - 1; i++) {
                    dizim[i] = dizim[i + 1];
                }

                // Son elemanı null yap
                dizim[size - 1] = null;
                size--;

                return silinen;
            } else {
                return null;
            }

        }
        @SuppressWarnings("unchecked")
        public T set(int index,T data){
            T kayıt ;

            if (index >= 0 && index < size){
                kayıt = (T) dizim[index];
                dizim[index]=data;
                return kayıt;
            }
            else {
                return null;
            }

        }

        public  int indexOf(T data){
            for (int i = 0; i < size ; i++) {
                if ((data==null&&dizim[i]==null) ||(data!=null &&data.equals(dizim[i]))){
                    return i;
                }
            }
            return -1;
        }


        public int lastIndexOf(T data){
            for (int i = size-1; i >=0; i--) {
                if ((data==null&&dizim[i]==null) ||(data!=null &&data.equals(dizim[i]))){
                    return i;
                }
            }
            return -1;
        }

        boolean isEmpty() {
            return size == 0;
        }

        public  void  clear(){

            for (int i = 0; i < size ; i++) {
                dizim[i]=null;

            }
            size =0;
        }

        public Object[] toArray(){
            Object[] copyArray =new Object[size];
            for (int i = 0; i < size; i++) {
                copyArray[i]=dizim[i];

            }
            return copyArray;
        }

        public boolean contains(T data){
            for (int i = 0; i < size; i++) {
                if ((data==null&&dizim[i]==null) ||(data!=null &&data.equals(dizim[i]))){
                    return true;
                }

            }
            return false;
        }
        public HomeworkListTypes<T> subList(int start, int finish){
            if (start >= 0 && start <= finish && finish <= size){
                HomeworkListTypes yenilist =new HomeworkListTypes<T>(finish-start);
                for (int i = start; i < finish; i++) {
                    yenilist.add(dizim[i]);
                }
                return yenilist;

            }else {
                throw new IndexOutOfBoundsException();
            }

        }

        @Override
        public String toString() {
            return "MyList{" +
                    "dizim=" + Arrays.toString(dizim) +
                    ", capacity=" + capacity +
                    ", size=" + size +
                    '}';
        }
    }

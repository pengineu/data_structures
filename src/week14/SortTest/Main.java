package week14.SortTest;

public class Main {                                         //main class
    public static void main(String[] args) {
        DataGenerator dg = new DataGenerator();             //DataGenerator 객체 생성
        System.out.println("===== Random Data =====");
        dg.generateRandomData(5000);                    //5000 크기의 random data 배열 생성
        testSort("Random", dg.getData(5000));      //testSort 호출
        System.out.println("===== Sequential Data =====");
        dg.generateRandomData(5000);                    //5000 크기의 순차 데이터 배열 생성
        testSort("Sequential", dg.getData(5000));   //testSort 호출
        System.out. println("===== Reverse Data =====");
        dg.generateReverseData(5000);                   //5000 크기의 반전 데이터 배열 생성
        testSort("Reversa", dg.getData(5000));      //testSort 호출

    }
    public static void testSort(String title, Integer[] data) { //testSort 메서드
        Integer[] copy;                                         //데이터를 copy하는 Integer 배열
        long start, end;                                        //시간을 기록하기 위한 start와 end 선언

        copy = data.clone();                                    //생성한 데이터 copy
        start = System.nanoTime();                              //시작 시간 기록
        Selection.sort(copy);                                   //SelectionSort
        end = System.nanoTime();                                //끝 시간 기록
        System.out.printf("%s Selection : %.3f ms%n", title, (end-start) / 1000000.0); //소요 시간 계산 및 출력

        copy = data.clone();                                    //생성한 데이터 copy
        start = System.nanoTime();                              //시작 시간 기록
        Insertion.sort(copy);                                   //InsertionSort
        end = System.nanoTime();                                //끝 시간 기록
        System.out.printf("%s Insertion : %.3f ms%n", title, (end-start) / 1000000.0);  //소요 시간 계산 및 출력

        copy = data.clone();                                    //생성한 데이터 copy
        start = System.nanoTime();                              //시작 시간 기록
        Shell.sort(copy);                                       //ShellSort
        end = System.nanoTime();                                //끝 시간 기록
        System.out.printf("%s Shell : %.3f ms%n", title, (end-start) / 1000000.0);  //소요 시간 계산 및 출력

        Integer[] heapData = new Integer[data.length + 1];      //HeapSort를 위한 copy용 배열 객체 생성
        heapData[0] = -1;                                       //0번째 인덱스는 사용하지 않음

        for (int i = 0; i < data.length; i++) {                 //data 크기만큼 순회
            heapData[i + 1] = data[i];                          //인덱스 + 1에 값 할당
        }
        start = System.nanoTime();                              //시작 시간 기록
        Heap.sort(heapData);                                    //HeapSort
        end = System.nanoTime();                                //끝 시간 기록
        System.out.printf("%s Heap : %.3f ms%n", title, (end-start) / 1000000.0);   //소요 시간 계산 및 출력

        copy = data.clone();                                    //생성한 데이터 copy
        start = System.nanoTime();                              //시작 시간 기록
        Merge.sort(copy);                                       //MergeSort
        end = System.nanoTime();                                //끝 시간 기록
        System.out.printf("%s Merge : %.3f ms%n", title, (end-start) / 1000000.0);  //소요 시간 계산 및 출력
        System.out.println();                                   //가독성을 위한 줄바꿈
    }
}

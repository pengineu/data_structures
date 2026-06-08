package week14.SortTest;
import java.util.Random;

public class DataGenerator {                        //data 생성 class
    private int[] _dataArray;                       //생성된 데이터 배열
    private int _dataSize;                          //생성된 데이터 크기

    public DataGenerator() {                        //생성자
        this._dataArray = null;                     //초기값 null
        this._dataSize = 0;                         //초기 사이즈 0
    }
    public void generateSequentialData(int size) {  //순차적 데이터 생성
        this._dataSize = size;                      //크기 설정
        this._dataArray = new int[size];            //배열 생성

        for (int i = 0; i < size; i++) {            //크기만큼 순회
            this._dataArray[i] = i + 1;             //순서대로 1부터 size까지 채움
        }
    }
    public void generateReverseData(int size) {     //반대로 된 데이터 생성
        this._dataSize = size;                      //크기 설정
        this._dataArray = new int[size];            //배열 생성

        for (int i = 0; i < size; i++) {            //크기만큼 순회
            this._dataArray[i] = size - i;          //순서대로 size부터 1까지 작아지도록 채움
        }

    }
    public void generateRandomData(int size) {      //무작위 데이터 생성
        this._dataSize = size;                      //크기 설정
        this._dataArray = new int[size];            //배열 생성
        Random random = new Random();               //랜덤 객체 생성
        int randomValue;                            //랜덤 값 선언

        generateSequentialData(size);               //순차적 데이터 생성
        for (int i = 0; i < size; i++) {            //크기만큼 순회
            randomValue = random.nextInt(size);     //랜덤 값 받기
            int temp = _dataArray[i];               //랜덤 인덱스와 자리바꾸기
            _dataArray[i] = _dataArray[randomValue];
            _dataArray[randomValue] = temp;         // -> 랜덤 데이터 생성 완료
        }
    }
    public Integer[] getData(int size) {            //데이터를 받아오는 메서드
        Integer[] data = new Integer[size];         //Integer 객체 새로 생성
        for (int i = 0; i < size; i++) {            //크기만큼 순회
            data[i] = this._dataArray[i];           //배열의 요소를 copy
        }
        return data;                                //copy한 데이터 반환
    }
}

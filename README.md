# 실전 자바 - 중급2편
***
## 제네릭 
제네릭을 사용하면 코드 재사용과 타입 안정성이라는 두 마리 토끼를 한 번에 잡을 수 있다.
```java
public class GenericBox<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```
* `<>`를 사용한 클래스를 제네릭 클래스라 한다. 이 기호(`<>`)는 보통 다이아몬드라 한다.
* 제네릭 클래스를 사용할 때는 Integer, String 같은 타입을 미리 결정하지 않는다.
* 대신 클래스명 오른쪽에 `<T>`와 같이 선언하면 제네릭 클래스가 된다. 여기서 `T`를 타입 매개변수라 한다. 이 타입 매개변수는 이후에 Integer, String으로 변할 수 있다.
* 클래스 내부에 `T` 타입이 필요한 곳에 `T value`와 같이 타입 매개변수를 적어두면 된다.

### 타입 추론
```java
 GenericBox<Integer> integerBox = new GenericBox<Integer>(); // 타입 선언
 GenericBox<Integer> integerBox = new GenericBox<>(); // 타입 추론
```

## 제네릭 용어와 관례
제네릭의 핵심은 사용할 타입을 미리 결정하지 않는 다는 점이다. 클래스 내부에서 사용하는 타입을 클래스를 정의하는 시점에 결정하는 것이 아니라 실제 사용하는 생성 시점에 타입을 경정하는 것이다.

### 용어 정리
* 제네릭(Generic) 단어
  * 제네릭이라는 단어는 일반적인, 범용적인이라는 영어 단어이다.
  * 풀어보면 특정 타입에 속한 것이 아니라 일반적으로, 범용적으로 사용할 수 있다는 뜻이다.
* 제네릭 타입(Generic Type)
  * 클래스나 인터페이스를 정의할 때 타입 매개변수를 사용하는 것을 말한다.
  * 제네릭 클래스, 제네릭 인터페이스를 모두 합쳐서 제네릭 타입이라 한다.
* 타입 매개변수(Type Parameter)
  * 제네릭 타입이나 메서드에서 사용되는 변수로, 실제 타입으로 대체 된다.
* 타입 인자(Type argument)
  * 제네릭 타입을 사용할 때 제공되는 실제 타입이다.

### 제네릭 명명 관례
타입 매개변수는 일반적인 변수명처럼 소문자로 사용해도 문제는 없다.
하지만 일반적으로 대문자를 사용하고 용도에 맞는 단어의 첫글자를 사용하는 관례를 따른다.
* E - Element
* K - Key
* N - Number
* T - Type
* V - Value
* S,U,V etc. - 2nd, 3rd, 4th types

### 제네릭 기타
다음과 같이 한번에 여러 타입 매개변수를 선언할 수 있다.
```java
class Data<K, V> {
    ...
}
```

> 타입 인자로 기본형은 사용할 수 없다.

### 타입 매개변수 제한
타입 매개변수를 특정 타입으로 제한할 수 있다.

```java
import generic.animal.Animal;

public class AnimalHospitalV3<T extends Animal> {

  private T animal;

  public void set(T animal) {
    this.animal = animal;
  }

  public void checkup() {
    System.out.println("동물 이름: " + animal.getName());
    System.out.println("동물 크기: " + animal.getSize());
    animal.sound();
  }

  public T bigger(T target) {
    return animal.getSize() > target.getSize() ? animal : target;
  }
}
```
타입 매개변수 `T`를 `Animal`과 그 자식만 받을 수 있도록 제한을 두는 것이다. 즉 `T`의 상한이 `Animal`이 되는 것이다.
자바 컴파일러는 `T`에 입력될 수있는 값의 범위를 예측할 수 있다.
따라서 `Animal`이 제공하는 `getName()`, `getSize()` 같은 기능을 사용할 수 있다.

### 제네릭 메서드
   
* 정의: `<T> T genericMethod(T t)`
* 타입 인자 전달: 메서드를 호출하는 시점
  * 예) GenericMethod.<Integer>genericMethod(i)


* 제네릭 메서드는 클래스 전체가 아니라 특정 메서드 단위로 제네릭을 도입할 때 사용한다.
* 제네릭 메서드를 정의할 때는 메서드의 반환 타입 왼쪽에 다이아몬드를 사용해서 `<T>`와 같이 타입 매개변수를 적어준다.
* 제네릭 메서드는 메서드를 실제 호출하는 시점에 다이아몬드를 사용해서 `<Integer>`와 같이 타입을 정하고 호출한다.

### 타입 매개변수 제한
제네릭 메서드도 제네릭 타입과 마찬자기로 타입 매개변수를 제한할 수 있다.
```java
public static <T extends Number> T numberMethod(T obj) {
    System.out.println("bound print: " + obj);
    return obj;
}
```

### 와일드 카드
이미 만들어진 제네릭 타입을 활용할 때 사용한다.
* 와일드 카드는 제네릭 타입이나 제네릭 메서드를 정의할 때 사용하는 것이 아니다.   
`Box<Dog>`, `Box<Cat>`처럼 타입인자가 정해진 제네릭 타입을 전달 받아서 활용할 때 사용한다.
* 와일드 카드인 `?`는 모든 타입을 다 받을 수 있다는 뜻이다.
  * `?`는 다음과 같다. `<? extends Object>`

#### 제네릭 메서드 VS 와일드 카드
제네릭 메서드는 특정 시점에 타입 매개변수에 타입 인자를 전달해서 타입을 결정해야 한다. 이 과정은 매우 복잡하다.
반면에 와일드 카드는 일반적인 메서드에 사용할 수 있고, 단순히 매개변수로 제네릭 타입을 받을 수 있는 것 뿐이다.
제네릭 메서드처럼 타입을 겨정하거나 복잡하게 작동하지않는다. 제네릭 타입이나 제네릭 메서드를 정의하는게 꼭 필요한 상황이 아니라면
더 단순한 와일드 카드 사용을 권장한다.

#### 타입 이레이저
제네릭은 자바 컴파일 단계에서만 사용되고, 컴파일 이후에는 제네릭 정보가 삭제 된다.
제네릭에 사용한 타입 매개변수가 모드 사라지는 것이다.

***

## 컬렉션 프레임워크 - ArrayList
### 배열의 특징 - 배열과 인덱스
* 배열에서 자료를 찾을 때 인덱스(index)를 사용하면 매우 빠르게 자료를 찾을 수 있다.
* 인덱스를 통한 입력, 변경, 조회의 경우 한번의 계산으로 자료의 위치를 찾을 수 있다.

#### 배열의 검색
배열에 들어있는 데이터를 찾는 것을 검색이라 한다.
배열에 들어있는 데이터를 검색할 때는 배열에 들어있는 데이터를 하나하나 비교해야 한다.
이때는 이전과 같이 인ㄷ게스를 사용해서 한번에 찾을 수 없다.
대신 배열안에 들어있는 데이터를 하나하나 확인해야 한다.
따라서 평균적으로 볼 때 배열의 크기가 클 수록 오랜 시간이 걸린다.

### 빅오(O) 표기법
빅오(Big O) 표기법은 알고리즘의 성능을 분석할 때 사용하는 수학적 표현 방식이다.
이는 특히 알고리즘이 처리해야할 데이터의 양이 증가할 때, 그 알고리즘이 얼마나 빠르게 실행되는지 나타낸다.
여기서 중요한 것은 알고리즘의 정확한 실행 시간을 계산하는 것이 아니라, 데이터 양의 증가에 따른 성능의 변화 추세를 이해하는 것이다.

#### 빅오 표기법의 예시
* O(1) - 상수시간: 입력 데이터의 크기에 관계없이 알고리즘의 실행 시간이 일정하다.
  * 예) 배열에서 인덱스를 사용하는 경우
* O(n) - 선형 시간: 알고리즘의 실행 시간이 입력 데이터의 크기에 비례하여 증가한다.
  * 예) 배열의 검색, 배열의 모든 요소를 순회하는 경우
* O(n²) - 제곱 시간: 알고리즘의 실행 시간이 입력 데이터의 크기에 제곱에 비례하여 증가한다.
  * 예) 보통 이중 루프를 사용하는 알고리즘에서 나타남
* O(log n) - 로그 시간: 알고리즘의 실행 시간이 데이터 크기의 로그에 비례하여 증가한다.
  * 예) 이진 탐색
* O(n long n) - 선형 로그 시간: 
  * 예) 많은 효율적인 정렬 알고리즘들

### 배열의 특징2 - 데이터 추가
추가는 기존 데이터를 유지하면서 새로운 데이터를 입력하는 것을 뜻한다.
데이터를 추가하려면 새로운 데이터를 입력할 공간을 확보해야 한다.

#### 배열에 데이터를 추가할 때 위치에 따른 성능 변화
* 배열의 첫번째 위치에 추가
  * 배열의 첫번째 위치를 찾는데 인덱스를 사용하므로 O(1)이 걸린다.
  * 모든 데이터를 배열의 크기만큼 한 칸씩 이동해야 한다. 따라서 O(n)만큼 연산이 걸린다.
  * O(1+n)-> O(n)이 된다.
* 배열의 중간 위치에 추가
  * 배열의 위치를 찾는데 O(1)이 걸린다.
  * index의 오른쪽에 있는 데이터를 모두 한 칸씩 이동해야 한다. 따라서 평균 연산은 O(n/2)이 된다.
  * O(1+n/2)->O(n)이 된다.
* 배열의 마지막 위치에 추가
  * 이 경우 배열이 이동하지 않고 배열의 길이를 사용하면 마지막 인덱스에 바로 접근할 수 있으므로 한번의 계산으로 위치를 찾을 수 있고, 기존 배열이 이동하지 않으므로 O(1)이 된다.
 
#### 배열의 한계
배열은 가장 기본적인 자료 구조이고, 특히 인덱스를 사용할 때 최고의 효율이 나온다.
하지만 이런 배열에는 큰 단점이 있다. 바로배열의 크기를 배열을 생성하는 시점에 정해야 한다는 점이다.

### 배열리스트
배열의 한계를 해소하고 동적으로 데이터를 추가할 수 있는 자료 구조를 List라 한다.

#### List 자료 구조
순서가 있고, 중복을 허용하는 자료 구조를 리스트라 한다.

### 동적 배열리스트
* 동적 배열리스트는 배열의 크기를 미리 정하지 않아도 된다.
* 배열의 여유 공간이 부족하면 자동으로 배열의 크기를 늘린다.
***
## 컬렉션 프레임워크 - LinkedList
### 노드와 연결
배열은 필요한 배열의 크기를 미리 확보해야 한다. 데이터가 얼마나 추가 될지 알 수 없는 경우
나머지 공간은 사용되지 않고 낭비된다. 배열의 앞이나 중간에서 데이터를 추가하거나 삭제할 경우 많은 양의 데이터들을 이동해야 하기 때문에
성능이 좋지 않다.

낭비되는 메모리 없이 딱 필요한 만큼만 메모리를 확보해서 사용하고, 또 앞이나 중간에 데이터를 추가, 삭제 할때도 효율적인 자료구조가 있다.
바로 노드를 만들고 각 노드들을 연결하는 방식이다.

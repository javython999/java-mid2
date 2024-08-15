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


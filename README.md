# 추상 클래스 연습 저장소: 패키지별 코드 해설

저장소의 `src`에는 **예제1_2, 예제1_4, 예제1_5, 예제1_6, 예제1_7** 패키지가 있습니다. 각 예제는 공통적으로 **추상 클래스에 공통 규칙을 정하고, 자식 클래스가 자기만의 동작을 구현하는 방법**을 보여줍니다.

[저장소의 코드 보기](https://github.com/sky688372-wq/java-abstract-class-practice/tree/main/%EC%B6%94%EC%83%81%ED%81%B4%EB%9E%98%EC%8A%A4_%EC%97%B0%EC%8A%B5/src)

---

## 1. 먼저 알아야 할 개념

### 추상 클래스란?

**추상 클래스**는 여러 클래스가 공유할 공통 규칙이나 기능을 담는 부모 클래스입니다. 다만 완성되지 않은 부분이 있을 수 있어서, 그 자체를 `new`로 만들어 객체로 사용할 수는 없습니다.

예를 들어 강아지와 고양이는 모두 동물이지만, "소리를 낸다"는 방법은 서로 다릅니다.

- 동물은 숨을 쉰다 → 모든 동물이 공유할 수 있는 기능
- 강아지는 멍멍 운다 → 강아지만의 기능
- 고양이는 야옹 운다 → 고양이만의 기능

이때 `Animal`에 숨 쉬는 기능을 넣고, 소리를 내는 방법은 자식 클래스가 각각 정하도록 만들 수 있습니다.

```java
public abstract class Animal {
    public void breath() {
        System.out.println("숨을 쉰다.");
    }

    public abstract void sound();
}
```

여기서:

- `abstract class`는 추상 클래스를 선언합니다.
- `public abstract void sound();`는 추상 메서드입니다.
- 추상 메서드는 **메서드의 이름과 규칙만 있고, 실제 실행 코드는 없습니다.**
- `Animal`을 상속받은 일반 클래스는 `sound()`를 구현해야 합니다.

> 추상 클래스는 "공통 규칙은 부모가 정하고, 구체적인 방법은 자식이 정하는 방식"입니다.

### 추상 클래스와 일반 클래스의 차이

| 구분 | 일반 클래스 | 추상 클래스 |
|---|---|---|
| 객체 생성 | `new`로 만들 수 있음 | 직접 만들 수 없음 |
| 일반 메서드 | 가질 수 있음 | 가질 수 있음 |
| 추상 메서드 | 가질 수 없음 | 가질 수 있음 |
| 사용 목적 | 객체의 구체적인 설계 | 공통 규칙을 가진 부모 설계 |

추상 클래스도 **필드, 생성자, 일반 메서드**를 가질 수 있습니다. 추상 클래스라고 해서 모든 메서드가 추상 메서드여야 하는 것은 아닙니다.

### 상속, 오버라이딩, 업캐스팅

```java
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
```

- `extends Animal`: `Dog`가 `Animal`을 상속한다는 뜻입니다.
- `@Override`: 부모 클래스의 메서드를 자식 클래스에서 다시 구현한다는 표시입니다.
- 업캐스팅: 자식 객체를 부모 타입 변수에 담는 것입니다.

```java
Animal animal = new Dog();
```

변수 타입은 `Animal`이지만 실제 객체는 `Dog`입니다. 따라서 `animal.sound()`를 실행하면 `Dog`가 구현한 `sound()`가 실행됩니다. 이것은 **다형성**의 한 예입니다.

---

## 2. `예제1_2` — 동물마다 다른 소리 내기

[예제1_2 코드](https://github.com/sky688372-wq/java-abstract-class-practice/tree/main/%EC%B6%94%EC%83%81%ED%81%B4%EB%9E%98%EC%8A%A4_%EC%97%B0%EC%8A%B5/src/%EC%98%88%EC%A0%9C1_2)

이 패키지는 추상 클래스의 가장 기본적인 용도인 **공통 기능은 물려주고, 달라지는 기능은 자식이 구현하기**를 보여줍니다.

### `Animal.java`: 공통 규칙과 기능

```java
package 예제1_2;

public abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public void breath() {
        System.out.println(name + "가(이) 숨을 쉰다.");
    }

    public abstract void sound();
}
```

- `abstract class Animal`: 동물의 공통 부모 클래스입니다.
- `name`: 동물의 이름을 저장하는 필드입니다.
- `Animal(String name)`: 자식 객체를 만들 때 이름을 받아 저장하는 생성자입니다.
- `breath()`: 동물이 공통으로 사용할 수 있는 일반 메서드입니다.
- `sound()`: 동물마다 소리가 다르므로 추상 메서드로 두었습니다.

`Animal`은 추상 클래스이므로 다음처럼 직접 객체를 만들 수 없습니다.

```java
// 불가능
Animal animal = new Animal("동물");
```

### `Dog.java`, `Cat.java`: 소리 구현

```java
package 예제1_2;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(name + ": 멍멍");
    }
}
```

```java
package 예제1_2;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(name + ": 야옹");
    }
}
```

`super(name)`은 부모 클래스 `Animal`의 생성자를 호출합니다. 부모 생성자에서 `name`을 저장하므로, 강아지와 고양이 클래스가 이름 저장 코드를 중복해서 작성할 필요가 없습니다.

또 두 클래스는 `Animal`의 추상 메서드인 `sound()`를 반드시 구현해야 합니다. 구현하지 않으면 해당 자식 클래스도 추상 클래스로 선언해야 합니다.

### `AnimalTest.java`: 부모 타입으로 여러 동물 다루기

```java
package 예제1_2;

public class AnimalTest {
    public static void animalSound(Animal animal) {
        animal.sound();
    }

    public static void main(String[] args) {
        Animal an = new Dog("스누피");
        an.sound();
        an.breath();
        AnimalTest.animalSound(an);

        System.out.println();

        an = new Cat("토미");
        an.sound();
        an.breath();
        AnimalTest.animalSound(an);
    }
}
```

`Animal an = new Dog("스누피");`는 `Dog` 객체를 부모 타입인 `Animal` 변수에 넣은 것입니다. 부모 타입으로 참조하더라도 `sound()`를 실행하면 **실제 객체의 클래스가 구현한 메서드**가 실행됩니다.

그래서 첫 번째에는 강아지의 "멍멍", 두 번째에는 고양이의 "야옹"이 출력됩니다. `animalSound()`도 `Animal` 타입을 받기 때문에 강아지와 고양이 모두 인자로 받을 수 있습니다.

> 이 예제의 핵심은 `Animal`이라는 공통 타입 하나로 여러 종류의 동물을 다룰 수 있다는 점입니다.

---

## 3. `예제1_4` — 계산기 기능을 자식 클래스가 구현하기

[예제1_4 코드](https://github.com/sky688372-wq/java-abstract-class-practice/tree/main/%EC%B6%94%EC%83%81%ED%81%B4%EB%9E%98%EC%8A%A4_%EC%97%B0%EC%8A%B5/src/%EC%98%88%EC%A0%9C1_4)

이 패키지는 **추상 메서드의 매개변수와 가변 인자**를 살펴보는 예제입니다.

### `Calculator.java`: 계산기 기능의 규칙

```java
package 예제1_4;

public abstract class Calculator {
    public abstract void add(int n1, int n2);
    public abstract void subtrack(int n1, int n2);
    public abstract void average(int... nums);
}
```

`Calculator`는 어떤 계산기든 더하기, 빼기, 평균 계산 기능을 제공해야 한다고 정합니다. 하지만 실제 계산 방법은 이 클래스에 작성하지 않고, 자식 클래스가 구현하도록 했습니다.

`int... nums`는 **가변 인자**입니다. 메서드 호출 때 정수의 개수를 다르게 전달할 수 있습니다.

```java
average(1, 2);
average(1, 2, 3, 4, 5);
```

가변 인자는 메서드 안에서 배열처럼 사용할 수 있습니다.

### `GoodCalcu.java`: 실제 계산 구현

저장소 코드의 핵심 부분은 다음과 같습니다.

```java
package 예제1_4;

public class GoodCalcu extends Calculator {
    @Override
    public void add(int n1, int n2) {
        System.out.println(
            n1 + "와 " + n2 + "의 덧셈 결과 = " + n1 + n2
        );
    }

    @Override
    public void subtrack(int n1, int n2) {
        System.out.println(
            n1 + "와 " + n2 + "의 뺄셈 결과 = " + (n1 - n2)
        );
    }

    @Override
    public void average(int... nums) {
        int sum = 0;

        for (int i : nums) {
            sum += i;
        }

        System.out.printf("평균 = %.2f\n", (double) sum / nums.length);
    }

    public static void main(String[] args) {
        GoodCalcu c = new GoodCalcu();

        c.add(2, 3);
        c.subtrack(2, 3);
        c.average(1, 2, 3, 4, 5, 6);
    }
}
```

#### 코드에서 조심할 점: 더하기 결과

현재 `add()`의 출력문은 다음과 같습니다.

```java
"... = " + n1 + n2
```

문자열과 숫자를 `+`로 연결하기 때문에, `2`와 `3`을 전달하면 수학적 결과인 `5`가 아니라 `23`처럼 출력됩니다. 덧셈을 먼저 하려면 괄호로 묶어야 합니다.

```java
@Override
public void add(int n1, int n2) {
    System.out.println(
        n1 + "와 " + n2 + "의 덧셈 결과 = " + (n1 + n2)
    );
}
```

#### 평균 계산에서 형변환하기

```java
(double) sum / nums.length
```

`sum`과 `nums.length`가 모두 정수라면 정수 나눗셈이 되어 소수점 이하가 사라질 수 있습니다. `(double) sum`처럼 실수형으로 바꾸면 소수점 계산이 됩니다.

`%.2f`는 결과를 소수점 둘째 자리까지 출력하라는 뜻입니다. 다만 아무 숫자도 전달하지 않으면 `nums.length`가 0이므로, 실제 프로그램에서는 빈 배열인 경우를 먼저 확인하는 편이 안전합니다.

---

## 4. `예제1_5` — 도형마다 다른 그리기와 넓이 계산

[예제1_5 코드](https://github.com/sky688372-wq/java-abstract-class-practice/tree/main/%EC%B6%94%EC%83%81%ED%81%B4%EB%9E%98%EC%8A%A4_%EC%97%B0%EC%8A%B5/src/%EC%98%88%EC%A0%9C1_5)

이 패키지에서는 부모 `Shape`가 도형의 공통 기능을 정하고, 자식인 `Rectangle`과 `Triangle`이 도형별 동작을 구현합니다.

### `Shape.java`: 도형의 공통 규칙

```java
package 예제1_5;

public abstract class Shape {
    public abstract void draw();
    public abstract void area(double row, double colum);
}
```

- 모든 도형은 `draw()`를 구현해야 합니다.
- 모든 도형은 `area()`를 구현해야 합니다.
- 도형마다 그리는 방법과 넓이 계산법이 다르므로 두 메서드를 추상 메서드로 선언했습니다.

### `Rectangle.java`, `Triangle.java`: 도형별 구현

```java
package 예제1_5;

public class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("사각형 그리기");
    }

    @Override
    public void area(double row, double colum) {
        System.out.printf("사각형의 넓이: %.2f\n", row * colum);
    }
}
```

```java
package 예제1_5;

public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("삼각형 그리기");
    }

    @Override
    public void area(double row, double colum) {
        System.out.printf("삼각형의 넓이: %.2f\n", (row * colum) / 2);
    }
}
```

사각형의 넓이는 `가로 × 세로`, 삼각형의 넓이는 `(밑변 × 높이) ÷ 2`로 계산합니다. 같은 `area()` 호출이라도 실제 객체가 `Rectangle`인지 `Triangle`인지에 따라 다른 계산식이 실행됩니다.

### `ShapeTest.java`: 같은 타입으로 여러 도형 실행

```java
package 예제1_5;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Rectangle();
        shape.draw();
        shape.area(5.0, 10.0);

        System.out.println("-----------------------");

        shape = new Triangle();
        shape.draw();
        shape.area(5.0, 10.0);
    }
}
```

`shape`의 타입은 계속 `Shape`지만, 첫 번째에는 사각형 객체를 담고 두 번째에는 삼각형 객체를 담습니다.

입력값이 `5.0`, `10.0`일 때 넓이는 각각 다음과 같습니다.

- 사각형: `5 × 10 = 50`
- 삼각형: `(5 × 10) ÷ 2 = 25`

`row`, `colum`이라는 이름은 동작에는 문제가 없지만 의미를 더 분명히 하려면 `width`, `height` 또는 `base`, `height`처럼 바꾸면 읽기 쉽습니다.

---

## 5. `예제1_6` — 가전제품의 공통 상태와 동작

[예제1_6 코드](https://github.com/sky688372-wq/java-abstract-class-practice/tree/main/%EC%B6%94%EC%83%81%ED%81%B4%EB%9E%98%EC%8A%A4_%EC%97%B0%EC%8A%B5/src/%EC%98%88%EC%A0%9C1_6)

이 예제는 추상 클래스가 추상 메서드뿐 아니라 **공통 필드, 생성자, 일반 메서드**도 가질 수 있음을 보여줍니다.

### `Apliance.java`: 모든 가전제품의 공통 부분

```java
package 예제1_6;

public abstract class Apliance {
    protected String brand;
    protected boolean isPowerOn;

    public Apliance(String brand) {
        this.brand = brand;
        isPowerOn = false;
    }

    public void turnOn() {
        isPowerOn = true;
        System.out.println(brand + "의 전원을 켭니다.");
    }

    public abstract void operate();
}
```

- `brand`: 제품 브랜드를 저장합니다.
- `isPowerOn`: 전원이 켜져 있는지 저장합니다.
- `protected`: 같은 패키지의 클래스와 자식 클래스에서 사용할 수 있는 접근 제한자입니다.
- 생성자는 전원을 처음에 `false`로 설정합니다.
- `turnOn()`은 모든 가전제품이 함께 쓸 수 있는 일반 메서드입니다.
- `operate()`는 제품마다 작동 방법이 다르므로 자식 클래스가 구현합니다.

### `WashingMachine.java`, `RobotCleaner.java`: 제품별 작동 방식

```java
package 예제1_6;

public class WashingMachine extends Apliance {
    public WashingMachine(String brand) {
        super(brand);
    }

    @Override
    public void operate() {
        if (isPowerOn) {
            System.out.println(brand + " 세탁기가 빨래를 시작합니다.");
            System.out.println("빨래가 완료되었습니다.");
        } else {
            System.out.println("전원을 켜주세요.");
        }
    }
}
```

```java
package 예제1_6;

public class RobotCleaner extends Apliance {
    public RobotCleaner(String brand) {
        super(brand);
    }

    @Override
    public void operate() {
        if (isPowerOn) {
            System.out.println(brand + " 로봇청소기가 청소를 시작합니다.");
            System.out.println("청소가 완료되었습니다.");
        } else {
            System.out.println("전원을 켜주세요.");
        }
    }
}
```

두 자식 클래스는 모두 부모 생성자에 브랜드를 전달하고, `operate()`를 각 제품에 맞게 구현합니다. 전원이 꺼져 있으면 작동하지 않고 전원을 켜 달라는 메시지를 출력합니다.

### `Test.java`: 실제 실행 순서

```java
package 예제1_6;

public class Test {
    public static void main(String[] args) {
        Apliance washer = new WashingMachine("LG 트롬");
        Apliance cleaner = new RobotCleaner("로보락");

        washer.operate();
        washer.turnOn();
        washer.operate();

        System.out.println();

        cleaner.turnOn();
        cleaner.operate();
    }
}
```

세탁기는 처음에 전원이 꺼져 있으므로 첫 번째 `washer.operate()`에서 "전원을 켜주세요."가 출력됩니다. `turnOn()`을 호출한 뒤에는 세탁 동작을 실행합니다.

여기서 `Apliance` 변수에 세탁기와 로봇청소기 객체를 담은 것이 업캐스팅입니다. 두 객체는 서로 다른 제품이지만, 부모 타입으로 공통 기능을 사용할 수 있습니다.

**참고:** `Apliance`라는 철자는 오타처럼 보일 수 있지만, 현재 코드에서 클래스 이름을 일관되게 사용하고 있으므로 컴파일 자체에는 문제가 없습니다. 다만 보통은 `Appliance`라고 씁니다.

---

## 6. `예제1_7` — 직원 유형별 급여 계산

[예제1_7 코드](https://github.com/sky688372-wq/java-abstract-class-practice/tree/main/%EC%B6%94%EC%83%81%ED%81%B4%EB%9E%98%EC%8A%A4_%EC%97%B0%EC%8A%B5/src/%EC%98%88%EC%A0%9C1_7)

이 예제에서는 정규직과 아르바이트 직원이 **직원이라는 공통점**은 있지만, 급여 계산 방식은 다르다는 점을 추상 메서드로 표현합니다.

### `Empolyee.java`: 직원의 공통 정보와 규칙

```java
package 예제1_7;

public abstract class Empolyee {
    String name;
    int id;

    public Empolyee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract int calculateSalry();

    void work() {
        System.out.println(
            "사원본호:" + id + ", 사원명: " + name + " 사원이 업무를 시작합니다."
        );
    }
}
```

- `name`, `id`: 모든 직원에게 공통인 이름과 사번입니다.
- 생성자: 이름과 사번을 저장합니다.
- `calculateSalry()`: 직원 유형별 급여 계산 방법이 달라 추상 메서드로 두었습니다.
- `work()`: 모든 직원이 공통으로 사용할 수 있는 메서드입니다.

접근 제한자를 별도로 적지 않았기 때문에 `name`, `id`, `work()` 등은 **같은 패키지 안에서 접근할 수 있는 상태**입니다. 다른 패키지에서도 사용할 계획이라면 `public`, `protected`, `private`을 목적에 맞게 지정하는 것이 좋습니다.

### `FullTimeEmpolyee.java`: 정규직 급여

```java
package 예제1_7;

public class FullTimeEmpolyee extends Empolyee {
    int baseSalary;
    int bouns;

    public FullTimeEmpolyee(
        String name, int id, int baseSalary, int bouns
    ) {
        super(name, id);
        this.baseSalary = baseSalary;
        this.bouns = bouns;
    }

    @Override
    int calculateSalry() {
        return baseSalary + bouns;
    }
}
```

정규직은 기본급과 보너스를 더해 급여를 계산합니다.

### `PartTimeEmpolyee.java`: 아르바이트 급여

```java
package 예제1_7;

public class PartTimeEmpolyee extends Empolyee {
    int hourRate;
    int workingHours;

    public PartTimeEmpolyee(
        String name, int id, int hourRate, int workingHours
    ) {
        super(name, id);
        this.hourRate = hourRate;
        this.workingHours = workingHours;
    }

    @Override
    int calculateSalry() {
        return hourRate * workingHours;
    }
}
```

아르바이트 직원은 시급과 근무 시간을 곱해 급여를 계산합니다.

### `Test.java`: 직원들을 한 배열에서 처리

```java
package 예제1_7;

public class Test {
    public static void main(String[] args) {
        Empolyee[] e = new Empolyee[2];

        e[0] = new FullTimeEmpolyee("강하늘", 123, 150, 300);
        e[1] = new PartTimeEmpolyee("진국화", 234, 100, 2);

        for (Empolyee employee : e) {
            employee.work();
            System.out.println(
                "급여: " + employee.calculateSalry() + "만원"
            );

            if (employee instanceof FullTimeEmpolyee) {
                FullTimeEmpolyee fullTime =
                    (FullTimeEmpolyee) employee;

                System.out.println(
                    "보너스: " + fullTime.bouns + "만원"
                );
                System.out.println();
            }
        }
    }
}
```

배열의 타입은 `Empolyee[]`이지만, 실제로는 정규직과 아르바이트 직원 객체가 들어갑니다. 반복문 안에서 `work()`를 실행하면 직원의 공통 기능을 사용하고, `calculateSalry()`는 실제 객체 종류에 따라 다르게 계산됩니다.

`instanceof`는 객체가 특정 클래스에 속하는지 확인합니다.

```java
employee instanceof FullTimeEmpolyee
```

정규직 객체일 때만 `FullTimeEmpolyee` 타입으로 다운캐스팅해 자식 클래스에만 있는 `bouns` 필드에 접근합니다. 부모 타입인 `Empolyee`에는 `bouns`가 선언되어 있지 않기 때문입니다.

계산 결과는 다음과 같습니다.

- 정규직: 기본급 150 + 보너스 300 = **450만 원**
- 아르바이트: 시급 100 × 근무 2시간 = **200만 원**

**참고:** 클래스 이름과 메서드 이름에 `Empolyee`, `Salry`, `bouns`처럼 철자 오류로 보이는 부분이 있습니다. 저장소 안에서 이름을 일관되게 사용하면 동작하지만, 코드를 다듬을 때는 `Employee`, `Salary`, `bonus`처럼 바꾸면 더 알아보기 쉽습니다. 단, 이름을 바꿀 때는 해당 이름을 사용하는 파일도 함께 수정해야 합니다.

---

## 7. 다섯 패키지의 공통 흐름

각 예제의 구조를 한 줄로 표현하면 다음과 같습니다.

```text
추상 부모 클래스가 공통 규칙을 정한다
          ↓
자식 클래스가 추상 메서드를 구현한다
          ↓
부모 타입 변수로 서로 다른 자식 객체를 다룬다
          ↓
실제 객체에 맞는 자식 메서드가 실행된다
```

| 패키지 | 추상 부모 | 자식 클래스 | 자식마다 달라지는 것 |
|---|---|---|---|
| `예제1_2` | `Animal` | `Dog`, `Cat` | `sound()` |
| `예제1_4` | `Calculator` | `GoodCalcu` | 계산 방식 |
| `예제1_5` | `Shape` | `Rectangle`, `Triangle` | 그리기와 넓이 계산 |
| `예제1_6` | `Apliance` | `WashingMachine`, `RobotCleaner` | 가전제품 작동 |
| `예제1_7` | `Empolyee` | `FullTimeEmpolyee`, `PartTimeEmpolyee` | 급여 계산 |

### 가장 중요하게 기억할 세 가지

1. **추상 클래스는 공통된 부모 설계도입니다.** 직접 객체를 만들 수 없습니다.
2. **추상 메서드는 자식 클래스가 반드시 채워야 하는 빈칸입니다.**
3. **부모 타입으로 자식 객체를 다루면, 실제 객체에 맞는 오버라이딩 메서드가 실행됩니다.** 이를 통해 여러 자식 클래스를 공통된 방식으로 다룰 수 있습니다.

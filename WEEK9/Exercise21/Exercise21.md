# Exercise 21: Printer

Create the class Printer, its constructor public Printer(String fileName) which receives a String standing for the file name, and the method public void printLinesWhichContain(String word) which prints the file lines which contain the parameter word (lower and upper case make difference in this excercise; for instance, "test" and "Test" are not the considered the same); the lines are printed in the same order as they are inside the file.

If the argument is an empty String, all of the file is printed.

If the file is not found, the constructor delegates the exception with no need for a try-catch statement; the constructor simply has to be defined in the following way:
```java
public Printer {

   public Printer(String fileName) throws Exception {
      // ...
   }

   // ...
}
```
The file textFile has been place into the default package of your project to help the tests. When you define the file name of the constructor of Printer, you have to write src/textfile.txt. The file contains an extract of Kalevala, a Finnish epic poem:
```
Siinä vanha Väinämöinen
katseleikse käänteleikse
Niin tuli kevätkäkönen
näki koivun kasvavaksi
Miksipä on tuo jätetty
koivahainen kaatamatta
Sanoi vanha Väinämöinen
```

The following example shows what the program should do:

```java
Printer printer = new Printer("src/textfile.txt");

printer.printLinesWhichContain("Väinämöinen");
System.out.println("-----");
printer.printLinesWhichContain("Frank Zappa");
System.out.println("-----");
printer.printLinesWhichContain("");
System.out.println("-----");
```
```
Prints:

Siinä vanha Väinämöinen
Sanoi vanha Väinämöinen
-----
-----
Siinä vanha Väinämöinen
katseleikse käänteleikse
Niin tuli kevätkäkönen
näki koivun kasvavaksi
Miksipä on tuo jätetty
koivahainen kaatamatta
Sanoi vanha Väinämöinen
```

 - I used a different text file (a file I made) for the text file, so the result is different.

output
```
Still Life(EN)
-----
song by BIGBANG
-----
Still Life(EN)
song by BIGBANG

A midsummer night's dream in spring when flowers bloom at sunset the following year
이듬해 질 녘 꽃 피는 봄 한여름 밤의 꿈

Fall Burn Winter Snow Fall Four Times a Year Spring Again
가을 타 겨울 내릴 눈 일 년 네 번 또다시 봄

Goodbye to my young days that I fell in love with
정들었던 내 젊은 날 이제는 안녕

Our beautiful spring summer autumn winter
아름답던 우리의 봄 여름 가을 겨울

(Four seasons with no reason)
(Four seasons with no reason)
After the rain, instead of sadness, a happy end
비 갠 뒤에 비애 대신 a happy end

A seven-color rainbow
비스듬히 씩 비웃듯 칠색 무늬의 무지개

I'm immature, I can't grow old (still)
철없이 철 지나 철들지 못해 (still)

It's been a long time since I lost my iron
철부지에 철 그른지 오래

Marchin' Vivaldi, Tchaikovsky
Marchin' 비발디, 차이코프스키

Welcome the four seasons today (boy)
오늘의 사계를 맞이해 (boy)

Finally, it's like the four can't
마침내, 마치 넷이 못내
just looking at the sky
저 하늘만 바라보고서

The four seasons are doing well, goodbye
사계절 잘 지내고 있어, goodbye

The person who left, the person who appeared again
떠난 사람 또 나타난 사람

The other world overhead, I'm leaving the amazon of inspiration
머리 위 저세상, 난 떠나 영감의 amazon

Asking all the trauma of last night
지난 밤의 트라우마 다 묻고

A shuttle that starts afresh, which will run at the cost of its life
목숨 바쳐 달려올 새 출발 하는 왕복선

I want to change, more than before
변할래 전보다는 더욱더

More and more good people, more and more better people
좋은 사람 더욱더, 더 나은 사람 더욱더
In the morning dew (in me)
아침 이슬을 맞고 (내 안에)

Burying the anger in the past
내 안에 분노 과거에 묻고

For life, do it away, away, away
For life, do it away, away, away
I miss the boy and girl who laughed and cried
울었던 웃었던 소년과 소녀가 그리워 나

I keep remembering the glorious days of love
찬란했던 사랑했던 그 시절만 자꾸 기억나
The seasons pass by day by day
계절은 날이 갈수록 속절없이 흘러

Dye it red and bruise blue, scan my chest
붉게 물들이고 파랗게 멍들어 가슴을 훑고
For the day that will come again someday (for you)
언젠가 다시 올 그날 그때를 위하여 (그대를 위하여)

Our spring summer autumn winter will be beautiful
아름다울 우리의 봄 여름 가을 겨울
La, la-la-la-la, la-la-la-la, la, la
La, la-la-la-la, la-la-la-la, la, la

La, la-la-la-la, la-la-la-la, la, la
La, la-la-la-la, la-la-la-la, la, la

La, la-la-la-la, la-la-la-la, la, la
La, la-la-la-la, la-la-la-la, la, la

La, la-la-la-la, la-la-la-la, la, la
La, la-la-la-la, la-la-la-la, la, la
A midsummer night's dream in spring when flowers bloom at sunset the following year (Um)
이듬해 질 녘 꽃 피는 봄 한여름 밤의 꿈 (음)

Fall Burning Winter Snow Falling Spring Summer Fall Winter (Right)
가을 타 겨울 내린 눈 봄 여름 가을 겨울 (우)
-----

Still Life
-----
song by BIGBANG
-----
Still Life
song by BIGBANG

이듬해 질 녘 꽃 피는 봄 한여름 밤의 꿈
가을 타 겨울 내릴 눈 일 년 네 번 또다시 봄
정들었던 내 젊은 날 이제는 안녕
아름답던 우리의 봄 여름 가을 겨울
(Four seasons with no reason)
비 갠 뒤에 비애 대신 a happy end
비스듬히 씩 비웃듯 칠색 무늬의 무지개
철없이 철 지나 철들지 못해 (still)
철부지에 철 그른지 오래
Marchin' 비발디, 차이코프스키
오늘의 사계를 맞이해 (boy)
마침내, 마치 넷이 못내
저 하늘만 바라보고서
사계절 잘 지내고 있어, goodbye
떠난 사람 또 나타난 사람
머리 위 저세상, 난 떠나 영감의 amazon
지난 밤의 트라우마 다 묻고
목숨 바쳐 달려올 새 출발 하는 왕복선
변할래 전보다는 더욱더
좋은 사람 더욱더, 더 나은 사람 더욱더
아침 이슬을 맞고 (내 안에)
내 안에 분노 과거에 묻고
For life, do it away, away, away
울었던 웃었던 소년과 소녀가 그리워 나
찬란했던 사랑했던 그 시절만 자꾸 기억나
계절은 날이 갈수록 속절없이 흘러
붉게 물들이고 파랗게 멍들어 가슴을 훑고
언젠가 다시 올 그날 그때를 위하여 (그대를 위하여)
아름다울 우리의 봄 여름 가을 겨울
La, la-la-la-la, la-la-la-la, la, la
La, la-la-la-la, la-la-la-la, la, la
La, la-la-la-la, la-la-la-la, la, la
La, la-la-la-la, la-la-la-la, la, la
이듬해 질 녘 꽃 피는 봄 한여름 밤의 꿈 (음)
가을 타 겨울 내린 눈 봄 여름 가을 겨울 (우)
-----

```

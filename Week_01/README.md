# 学习心得
## 关于刷题
### 使用五毒神掌刷题
1. 第一遍
    1. 读题+思考5-10分钟
        1. 如果没有思路，则直接查看题解
        2. 如果有了思路，则将解法思路都写下来，找出最优解
    2. 将最优解背下来
2. 第二遍：将第一遍的解法都尝试一遍，出错的话自己debug，并且到国际站看高票解答
3. 第三遍：过了一天后，在回过头做前一天做过的题，并把不熟练的收集起来，多次训练
4. 第四遍：一周过后回过头来完成题目
5. 第五遍：根据面试安排，在面试前一段时间进行训练，练习之前做过的题


## JAVA Queue分析
### 简介
1. `Queue`本身是一种先入先出的模型(FIFO)，和我们日常生活中的排队模型很类似。
2. `Queue`在JAVA中是一个接口，定义了`Queue`应该有的功能。实际上有多个Queue的实现，有的是采用线性表实现，有的基于链表实现。还有的适用于多线程的环境。

### 主要方法
1. `boolean add(E e)`：在队列插入指定元素，插入失败时，会抛出异常
2. `boolean offer(E e)`：在队列插入指定元素，插入失败时，返回`false`
3. `E remove()`：删除并返回队头的元素，删除失败时，会抛出异常
4. `E poll()`：删除并返回队头的元素，删除失败时，会返回`null`
5. `E element()`：返回队头元素，如果获取失败，则抛出异常
6. `E peek()`：返回队头元素，如果获取失败，则返回`null`

## JAVA PriorityQueue源码分析
### 简介
1. `PriorityQueue`即优先队列。优先队列的作用时保证每次取出的元素都是队列中权值最小（或最大）的元素。
2. JAVA中的`PriorityQueue`实现了`Queue`接口，并且实现的是每次取出最小值。

### 主要方法
1. `boolean add(E e)`：在优先队列中插入指定元素，失败时会抛出异常
```java
public boolean add(E e) {
    return offer(e);    // 直接调用offer方法
}
```
2. `boolean offer(E e)`：在优先队列中插入指定元素，失败时会返回`false`
```java
public boolean offer(E e) {
    // 如果原为为null直接抛出异常
    if (e == null)
        throw new NullPointerException();
    // 修改次数增加
    modCount++;
    // 扩容
    int i = size;
    if (i >= queue.length)
        grow(i + 1);
    size = i + 1;
    // 将元素插入的最后位置，然后进行调整
    if (i == 0)
        queue[0] = e;
    else
        siftUp(i, e);
    return true;
}
```
3. `E remove()`：删除并返回最小的元素，删除失败时，会抛出异常
```java
public E remove() {
    // 从上往下查找，如果找不到，则抛出异常
    E x = poll();
    if (x != null)
        return x;
    else
        throw new NoSuchElementException();
}
```
4. `boolean remove(Object o)`：删除指定元素，如果删除失败，返回`false`
```java
public boolean remove(Object o) {
    // 找到元素所在位置，若找到则返回位置，找不到返回-1
    int i = indexOf(o);
    // 如果找不到返回false
    if (i == -1)
        return false;
    else {
        // 找到元素位置，将元素移除
        removeAt(i);
        return true;
    }
}
```
5. `E poll()`：删除并返回最小的元素，删除失败时，会返回`null`
```java
public E poll() {
    // 如果队列为空，则直接返回null
    if (size == 0)
        return null;
    int s = --size;
    modCount++;
    // 获取优先队列最小值
    E result = (E) queue[0];
    E x = (E) queue[s];
    queue[s] = null;
    if (s != 0)
        // 下沉操作
        siftDown(0, x);
    return result;
}
```
6. `E peek()`：返回最小的元素，如果获取失败，则返回`null`
```java
public E peek() {
    // 如果队列不为空，则返回第一个元素
    return (size == 0) ? null : (E) queue[0];
}
```
# 学习心得

## 冒泡排序
```java
public void bubbleSort(int[] arr) {
    int len = arr.length;
    if (len <= 1) return;
    for (int i = 0; i < len; i++) {
        boolean flag = false;
        for (int j = 0; j < len - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                flag = true;
            }
        }
        // 如果没有数据交换，就退出
        if(!flag) break;
    }
}
```

## 选择排序
```java
public void selectionSort(int[] arr) {
    int len = arr.length;
    if (len <= 1) return;
    for (int i = 0; i < len - 1; i++) {
        int minIndex = i;
        // 找出待排序区间中最小的元素
        for (int j = i + 1; j < len; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
```

## 基数排序
```java
public void radixSort(int[] arr, int maxDigit) {
    int len = arr.length;
    if (len <= 1) return;
    int mod = 10;
    int div = 1;
    // 初始化桶
    List<List<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
        buckets.add(new ArrayList<>());
    }
    for (int i = 1; i <= maxDigit; i++, mod *= 10, div *= 10) {
        // 将元素放入到对应的桶中
        for (int a : arr) {
            // 321 % 100 / 10 = 2
            int index = (a % mod) / div;
            buckets.get(index).add(a);
        }
        // 将元素拷贝回原数组
        for (int j = 0, k = 0; j < buckets.size(); j++) {
            for (int e : buckets.get(j)) {
                arr[k++] = e;
            }
            buckets.get(j).clear();
        }
    }
}
```

## 桶排序
```java
public void bucketSort(int[] arr) {
    int len = arr.length;
    if (len <= 1) return;
    int max = arr[0], min = arr[0];
    for (int a : arr) {
        max = Math.max(a, max);
        min = Math.min(a, min);
    }
    // 每个桶中的元素区间为[a, a + step)
    int step = 10;
    int bucketNum = (max - min) / step + 1;
    List<List<Integer>> buckets = new ArrayList<>();
    for (int i = 1; i <= bucketNum; i++) {
        buckets.add(new ArrayList<>());
    }
    // 把元素压入桶中
    for (int a : arr) {
        // 获取元素所属的桶的索引
        int index = indexFor(a, min, step);
        buckets.get(index).add(a);
    }
    // 分别对每个桶排序，然后把元素存入原数组
    for (int i = 0, index = 0; i < bucketNum; i++) {
        Collections.sort(buckets.get(i));
        for (int k : buckets.get(i)) {
            arr[index++] = k;
        }
    }
}

private int indexFor(int a, int min, int step) {
    return (a - min) / step;
}
```

## 插入排序
```java
public void insertionSort(int[] arr) {
    int len = arr.length;
    if (len <= 1) return;
    int temp;
    // 挑选一个元素，插入到已排序区间
    for (int i = 1; i < len; i++) {
        temp = arr[i];
        int j = i - 1;
        // 寻找插入位置
        while (j >= 0 && temp < arr[j]) {
            arr[j + 1] = arr[j--];
        }
        arr[j + 1] = temp;
    }
}
```

## 希尔排序
```java
public void shellSort(int[] arr) {
    int len = arr.length;
    if (len <= 1) return;
    int temp;
    // 选取步长
    for (int step = len / 2; step >= 1; step /= 2) {
        // 选择插入元素
        for (int i = step; i < len; i++) {
            temp = arr[i];
            int j = i - step;
            // 查找插入位置
            while (j >= 0 && arr[j] > temp) {
                arr[j + step] = arr[j];
                j -= step;
            }
            arr[j + step] = temp;
        }
    }
}
```

## 归并排序
```java
public void mergeSort(int[] arr) {
    mergeSort(arr, 0, arr.length - 1);
}

private void mergeSort(int[] arr, int left, int right) {
    if (right <= left) return;
    int mid = left + ( right - left) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

// 合并
private void merge(int[] arr, int left, int mid, int right) {
    // 中间数组
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;
    while (i <= mid && j <= right) {
        temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    }
    while (i <= mid) {
        temp[k++] = arr[i++];
    }
    while (j <= right) {
        temp[k++] = arr[j++];
    }
    System.arraycopy(temp, 0, arr, left, temp.length);
}
```

## 堆排序
```java
public void heapSort(int[] arr) {
    int len = arr.length;
    if (len <= 1) return;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int a : arr) {
        pq.add(a);
    }
    for (int i = 0; i < len; i++) {
        arr[i] = pq.poll();
    }
}
```

## 计数排序
```java
public void countingSort(int[] arr) {
    int len = arr.length;
    if (len <= 1) return;
    // 查找最大值和最小值
    int max = arr[0], min = arr[0];
    for (int a : arr) {
        max = Math.max(a, max);
        min = Math.min(a, min);
    }
    // 计数数组
    int[] c = new int[max - min + 1];
    // 统计元素个数
    for (int a : arr) {
        c[a - min]++;
    }
    // 拷贝回原数组
    for (int i = 0, j = 0; i < c.length; i++) {
        while (c[i] > 0) {
            // 注意这里是索引 i + min
            arr[j++] = i + min;
            c[i]--;
        }
    }
}
```

## 快速排序
```java
public void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
}

private void quickSort(int[] arr, int start, int end) {
    if (end <= start) return;
    int pivot = partition(arr, start, end);
    quickSort(arr, start, pivot - 1);
    quickSort(arr, pivot + 1, end);
}

// 分区函数，把小的元素放左侧，大的元素放右侧
private int partition(int[] arr, int start, int end) {
    // 选择最后一个元素作为 pivot
    int pivot = end;
    // 小于 pivot 的元素索引指针
    int i = start;
    // 将 pivot 放在数组的末尾
    // i 指针指向了比 pivot 大的元素，j 指针用于遍历整个数组
    // 当 arr[j] < arr[pivot] 时，交换 arr[i] 和 arr[j]
    // 最后将 pivot 放到数组中间
    for (int j = start; j < end; j++) {
        if (arr[j] < arr[pivot]) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j] = temp;
        }
    }
    int temp = arr[pivot];
    arr[pivot] = arr[i];
    arr[i] = temp;
    return i;
}
```
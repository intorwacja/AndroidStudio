package com.example.fragmentssortowanie

object Sorting {
    fun arrayStringToInt(input: Array<String>): IntArray {
        val output = IntArray(input.size)
        for (i in input.indices) {
            output[i] = input[i].toInt()
        }
        return output
    }

    fun bubbleSort(input: String): IntArray {
        val arrStr = input.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val arr = arrayStringToInt(arrStr)
        val n = arr.size
        var i: Int
        var j: Int
        var temp: Int
        var swapped: Boolean
        i = 0
        while (i < n - 1) {
            swapped = false
            j = 0
            while (j < n - i - 1) {
                if (arr[j] > arr[j + 1]) {


                    temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                    swapped = true
                }
                j++
            }

            if (swapped == false) break
            i++
        }
        return arr
    }

    fun insertionSort(input: String): IntArray {
        val arr = arrayStringToInt(input.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
        val n = arr.size
        for (i in 1 until n) {
            val key = arr[i]
            var j = i - 1

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]
                j = j - 1
            }
            arr[j + 1] = key
        }
        return arr
    }

    fun merge(arr: IntArray, l: Int, m: Int, r: Int) {
        val n1 = m - l + 1
        val n2 = r - m

        val L = IntArray(n1)
        val R = IntArray(n2)

        for (i in 0 until n1) L[i] = arr[l + i]
        for (j in 0 until n2) R[j] = arr[m + 1 + j]


        var i = 0
        var j = 0

        var k = l
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i]
                i++
            } else {
                arr[k] = R[j]
                j++
            }
            k++
        }

        while (i < n1) {
            arr[k] = L[i]
            i++
            k++
        }

        while (j < n2) {
            arr[k] = R[j]
            j++
            k++
        }
    }

    fun mergeSort(arr: IntArray, l: Int, r: Int): IntArray {
        if (l < r) {

            val m = l + (r - l) / 2

            mergeSort(arr, l, m)
            mergeSort(arr, m + 1, r)

            merge(arr, l, m, r)
        }
        return arr
    }

    fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]

        var i = (low - 1)

        for (j in low..high - 1) {

            if (arr[j] < pivot) {

                i++
                swap(arr, i, j)
            }
        }
        swap(arr, i + 1, high)
        return (i + 1)
    }

    fun quickSort(arr: IntArray, low: Int, high: Int): IntArray {
        if (low < high) {

            val pi = partition(arr, low, high)

            quickSort(arr, low, pi - 1)
            quickSort(arr, pi + 1, high)
        }
        return arr
    }
}

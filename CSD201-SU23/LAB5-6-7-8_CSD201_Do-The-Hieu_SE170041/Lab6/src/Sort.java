import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Sort {
    public static void insertionSort(Employee[] empList, boolean asc) {
        insertionSort(empList);
        if (!asc) {
            Collections.reverse(Arrays.asList(empList));
        }
    }

    public static void bubbleSort(Employee[] empList, boolean asc) {
        bubbleSort(empList);
        if (!asc) {
            Collections.reverse(Arrays.asList(empList));
        }
    }

    public static void selectionSort(Employee[] empList, boolean asc) {
        selectionSort(empList);
        if (!asc) {
            Collections.reverse(Arrays.asList(empList));
        }
    }

    public static void heapSort(Employee[] empList, boolean asc) {
        heapSort(empList);
        if (!asc) {
            Collections.reverse(Arrays.asList(empList));
        }
    }

    public static void mergeSort(Employee[] empList, boolean asc) {
        mergeSort(empList, 0, empList.length - 1);
        if (!asc) {
            Collections.reverse(Arrays.asList(empList));
        }
    }

    public static void quickSort(Employee[] empList, boolean asc) {
        quickSort(empList, 0, empList.length - 1);
        if (!asc) {
            Collections.reverse(Arrays.asList(empList));
        }
    }

    private static void quickSort(Employee[] empList, int l, int r) {
        int i = l, j = r;
        Employee mid = empList[(l + r) >> 1];
        while (i < j) {
            while (empList[i].compareTo(mid) < 0) {
                i++;
            }
            while (empList[j].compareTo(mid) > 0) {
                j--;
            }
            if (empList[i].compareTo(empList[j]) <= 0) {
                Employee tmp = empList[i];
                empList[i] = empList[j];
                empList[j] = tmp;
                i++;
                j--;
            }
        }
        if (l < j) {
            quickSort(empList, l, j);
        }
        if (i < r) {
            quickSort(empList, i, r);
        }
    }

    private static void insertionSort(Employee[] empList) {
        int n = empList.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && empList[i].compareTo(empList[j - 1]) < 0) {
                j--;
            }
            Employee tmp = empList[i];
            for (int k = i; k > j; k--) {
                empList[k] = empList[k - 1];
            }
            empList[j] = tmp;
        }
    }

    private static void selectionSort(Employee[] empList) {
        int n = empList.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (empList[j].compareTo(empList[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Employee tmp = empList[i];
            empList[i] = empList[minIndex];
            empList[minIndex] = tmp;
        }
    }

    private static void bubbleSort(Employee[] empList) {
        int n = empList.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (empList[i].compareTo(empList[j]) > 0) {
                    Employee tmp = empList[i];
                    empList[i] = empList[j];
                    empList[j] = tmp;
                }
            }
        }
    }

    private static void heapSort(Employee[] empList) {
        PriorityQueue<Employee> heap = new PriorityQueue<>();
        heap.addAll(Arrays.asList(empList));
        for (int i = 0; i < empList.length; i++) {
            empList[i] = heap.poll();
        }
    }

    private static void mergeSort(Employee[] empList, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(empList, l, mid);
            mergeSort(empList, mid + 1, r);
            merge(empList, l, mid, r);
        }
    }

    private static void merge(Employee[] empList, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        Employee[] leftArray = new Employee[n1];
        Employee[] rightArray = new Employee[n2];

        System.arraycopy(empList, l, leftArray, 0, n1);
        System.arraycopy(empList, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                empList[k] = leftArray[i];
                i++;
            } else {
                empList[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            empList[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            empList[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

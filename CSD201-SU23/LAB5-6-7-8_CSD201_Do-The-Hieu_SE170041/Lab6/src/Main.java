public class Main {
    public static void main(String[] args) {
        // Part 1: Basic Sorting
        System.out.println("Part 1: Basic Sorting");
        Employee[] employees = {
            new Employee("A05", "Tran Quang", 7),
            new Employee("A03", "Nguyen An", 7),
            new Employee("A01", "Truong Phung", 5),
            new Employee("A04", "Pham Thi Lam", 2),
            new Employee("A02", "Do Trung Ton", 5)
        };
        
        System.out.println("Original Employee List:");
        printEmployees(employees);
        
        // Sort in ascending order by ID using insertion sort
        Sort.insertionSort(employees, true);
        System.out.println("Sorted Employee List (Ascending Order - Insertion Sort):");
        printEmployees(employees);
        
        // Sort in descending order by ID using selection sort
        Sort.selectionSort(employees, false);
        System.out.println("Sorted Employee List (Descending Order - Selection Sort):");
        printEmployees(employees);
        
        // Sort in ascending order by ID using bubble sort
        Sort.bubbleSort(employees, true);
        System.out.println("Sorted Employee List (Ascending Order - Bubble Sort):");
        printEmployees(employees);
        
        // Part 2: Advanced Sorting
        System.out.println("Part 2: Advanced Sorting");
        Employee[] employees2 = {
            new Employee("A05", "Tran Quang", 7),
            new Employee("A03", "Nguyen An", 7),
            new Employee("A01", "Truong Phung", 5),
            new Employee("A04", "Pham Thi Lam", 2),
            new Employee("A02", "Do Trung Ton", 5)
        };
        
        System.out.println("Original Employee List:");
        printEmployees(employees2);
        
        // Sort in ascending order by ID using heap sort
        Sort.heapSort(employees2, true);
        System.out.println("Sorted Employee List (Ascending Order - Heap Sort):");
        printEmployees(employees2);
        
        // Sort in descending order by ID using quick sort
        Sort.quickSort(employees2, false);
        System.out.println("Sorted Employee List (Descending Order - Quick Sort):");
        printEmployees(employees2);
        
        // Sort in ascending order by ID using merge sort
        Sort.mergeSort(employees2, true);
        System.out.println("Sorted Employee List (Ascending Order - Merge Sort):");
        printEmployees(employees2);
    }
    
    private static void printEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();
    }
}

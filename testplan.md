# Test plan

## class - DataUtilities 

### Method 1: createNumberArray

public static java.lang.Number[] createNumberArray(double[] data)
Constructs an array of Number objects from an array of double primitives.

### Partitions

#### data
     An array of double primitives
- expected:
    - array of size more than one
    - array of size one
    - array of size zero
- unexpected 
    - null
    
| Test Case                                | Description                              | data      | Expected                 | Test Type    |
|------------------------------------------|------------------------------------------|-----------|--------------------------|--------------|
| testCreateNumberArrayNullInput           | to test the null input as an input       | null      | IllegalArgumentException | ECT          |
| testCreateNumberArrayWithSizeMoreThanOne | to test array with size of more than one | [1 2 ...] | number array([1 2 ...])  | ECT          |
| testCreateNumberArrayWithSizeOne         | to test array with size one              | [5]       | number array([5])        | Boundary ALB |
| testCreateNumberArrayWithSizeZero        | to test array with size zero             | []        | number array([])         | Boundary LB  |

### Method 2: createNumberArray2D

public static java.lang.Number[][] createNumberArray2D(double[][] data)
Constructs an array of arrays of Number objects from a corresponding structure containing double primitives.

### Partitions

#### data
     An array of 2D double primitives (null not permitted)
- expected:
    - array of size more than one row and column
    - array with one column
    - array with one row
    - array with zero column
    - array with zero row
- unexpected 
    - null
    
| Test Case                                  | Description                              | data                | Expected                          | Test Type    |
|--------------------------------------------|------------------------------------------|---------------------|-----------------------------------|--------------|
| testCreateNumberArray2dNullInput           | to test the null input as an input       | null                | IllegalArgumentException          | ECT          |
| testCreateNumberArray2dWithSizeMoreThanOne | to test array with size of more than one | [1 2 ...] [1 2 ...] | number array([1 2 ...] [1 2 ...]) | ECT          |
| testCreateNumberArray2dWithOneRow          | to test array with one row               | [[1 2 ...]]         | number array([[1 2 ...]])         | Boundary ALB |
| testCreateNumberArray2dWithOneColumn       | to test array with one column            | [[1 2 ...]]         | number array([[1 2 ...]])         | Boundary ALB |
| testCreateNumberArray2dWithZeroColumn      | to test array with zero column           | [[]]                | number array([[]])                | Boundary LB  |
| testCreateNumberArray2dWithZeroRow         | to test array with zero row              | [[]]                | number array([[]])                | Boundary LB  |


### Method 2: calculateColumnTotal 

public static double calculateColumnTotal(Values2D data,
                                          int column)
Returns the sum of the values in one column of the supplied data table. With invalid input, a total of zero will be returned.


#### Input 

-data
    the table of values 
    null not permitted
-column 
    Zero based column index


#### Output

-An array of Number objects.

### Partitions
 
 ##### values2D

-Expected 
    -values2D object with valid values
    -values2D object with values
-Unexpected
    -values2D object with unvalid objects
    -null

##### Column

-Expected
    Any values within the table size
    Zero
-Unexpected
    values larger than table size
    negetive values 
    String 


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


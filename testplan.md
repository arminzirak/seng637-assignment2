



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


### Method 3: calculateColumnTotal 

public static double calculateColumnTotal(Values2D data, int column)
Returns the sum of the values in one column of the supplied data table. With invalid input, a total of zero will be returned.

### Partitions

#### data
     the table of values (null not permitted)
- expected:
    - array with width more than one and height more than one
    - array with width equals to one and height more than one
    - array with width more than one and height equals to one
    - array with width equals to one and height equals to one
- unexpected
    - null

#### column
     the column index
- expected:
    - int in range of [0, (the number of columns - 1)]
- unexpected
    - less than zero
    - more than the number of columns


| Test Case                                | Description                                    | Data                         | Column | Expected                  | Test Type   |
|------------------------------------------|------------------------------------------------|------------------------------|--------|---------------------------|-------------|
| testCalculateColumnTotalBasic            | to test the function with normal inputs        | [[1,2,3], [10, 20, 30]]      | 1      | 21                        | ECT         |
| testCalculateColumnTotalLastColumn       | to the the function with last column           | [[1,2,3], [10, 20, 30]]      | 2      | 33                        | Boundary UB |
| testCalculateColumnTotalWithColumnZero   | to test the function with first column         | [[1,2,3], [10, 20, 30]]      | 0      | 11                        | Boundary LB |
| testCalculateColumnTotalWithMissingValue | to test the function with missing values       | [[1, null, 3], [10, 20, 30]] | 1      | 20                        | ECT         |
| testCalculateColumnTotalOneRow           | to test the function with a data of one row    | [[0, 1, 2]]                  | 1      | 3                         | ECT         |
| testCalculateColumnTotalOneColumn        | to test the function with a data of one column | [[10] [20]]                  | 0      | 10                        | ECT         |
| testCalculateColumnTotalWithNullInput    | to test the function with null input           | null                         | 1      | InvalidParameterException | ECT         |


### Method 4: calculateRowTotal

public static double calculateRowTotal(Values2D data, int row)
Returns the sum of the values in one row of the supplied data table. With invalid input, a total of zero will be returned.

### Partitions

#### data

     the table of values (null not permitted)
- expected:
  - array with width more than one and height more than one
  - array with width equals to one and height more than one
  - array with width more than one and height equals to one
  - array with width equals to one and height equals to one
- unexpected
  - null

#### row
     the column index
- expected:
  - int in range of [0, (the number of row - 1)]
- unexpected
  - less than zero
  - more than the number of rows


| Test Case                                | Description                                    | Data                         | Row | Expected                  | Test Type   |
|------------------------------------------|------------------------------------------------|------------------------------|--------|---------------------------|-------------|
| testCalculateRowTotalBasic            | to test the function with normal inputs        | [[1,2,3], [10, 20, 30]]      | 0      | 6                        | ECT         |
| testCalculateRowTotalLastRow       | to the the function with last column           | [[1,2,3], [10, 20, 30]]      | 1      | 60                        | Boundary UB |
| testCalculateRowTotalWithMissingValue | to test the function with missing values       | [[1, null, 3], [10, 20, 30]] | 0      | 20                        | ECT         |
| testCalculateRowTotalOneRow           | to test the function with a data of one row    | [[0, 1, 2]]                  | 0      | 3                         | ECT         |
| testCalculateRowTotalOneRow        | to test the function with a data of one column | [[10] [20]]                  | 0      | 10                        | ECT         |
| testCalculateRowTotalWithNullInput    | to test the function with null input           | null                         | 1      | InvalidParameterException | ECT         |


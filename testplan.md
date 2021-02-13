# Test plan

## class - Datautilities 

### Method 1: createNumberArray

Constructs an array of Number objects from an array of double primitives.

#### Input 

-Array of double primitives.

#### Output

-An array of Number objects.

### Partitions




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


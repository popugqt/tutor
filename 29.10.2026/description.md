
    j=0 j=1 j=2   
i=?    1  2  3
i=?    4  10 6
i=?    7  8  9

--- i=0

arr = [1, 2, 3]
state = [true, true, true] // Текущий столбик подходит по условию
count = 3

--- i=1

arr = [4, 10, 6]
state = [true, true, true]
count = 3

--- i=2

arr = [7, 8, 9]
state = [true, false, true]
count = 2

--- result

count = 2
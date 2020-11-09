# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A, K):
    # write your code in Python 3.6

    #print(A)
    # we must catch the case of modulo by 0 error
    array_length = len(A)
    if array_length == 0:
        return A

    number_of_shifts_required = K % array_length
    #print(number_of_shifts_required)

    if number_of_shifts_required == 0:
        return A

    # Now use list slicing with K as the parameter to return the list that
    # has been shifted k times

    A = A[-number_of_shifts_required:] + A[:-number_of_shifts_required]

    return A

# testcase 1
A = [3, 8, 9, 7, 6]
K = 3
print(solution(A , K))

# testcase 2
A = [0, 0, 0]
K = 1
print(solution(A , K))

# testcase 3
A = [1, 2, 3, 4]
K = 4
print(solution(A , K))

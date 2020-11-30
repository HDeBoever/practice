# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6


    # task asks to find the unpaired element in a list of length N

    # my strategy will be to use a dictionary

    hashmap_pairs = {}

    # populate the dictionary by iterating through the list to populate the keys, set values to 0
    for number in A:
        if number not in hashmap_pairs:
            hashmap_pairs[number] = 0

    # now count how many times each key appears:
    for number in A:
        hashmap_pairs[number] += 1

    # now, see which element only has an occurence of an odd number of times
    for key, value in hashmap_pairs.items():
        if value%2 != 0:
            return key

    '''
    Since we are only running through A to get all the data we need, run time should be O(N), optimal in this case
    '''

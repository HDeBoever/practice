import sys

def nthFibonacci (n):
    # code here
    # initialize an array long enough to store our solutions
    fib_numbers = [None]*(n+1)

    fib_numbers[0] = 0
    fib_numbers[1] = 1

    for i in range(2, n+1):
        fib_numbers[i] = fib_numbers[i-1] + fib_numbers[i-2]

    print(fib_numbers[n])

def main():

    print("In main")
    nthFibonacci(int(sys.argv[1]))

if __name__ == "__main__":
    main()

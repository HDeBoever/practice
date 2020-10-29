class Solution:

	# recursive solution is good since the recursion depth is limited by the size of the chess board
	def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:

		#Converting the array into set for O(1) ---> Search
		Queens = set()

		for  i,j in queens:
			Queens.add((i,j))

		#To store the result
		ans=[]

		#Recursive code
		def check(x,y,xPosition,yPosition):

			#Base Case
			if x>=8 or y>=8 or x<0 or y<0:
				return

			#Check whether the co-ordinate is present in the set or not
			if (x,y) in Queens:
				#If present add to ans and return
				ans.append([x,y])
				return
			#if not present go to the next coordinate
			# (xPosition and yPosition has value 0 1 -1 to decide the 8 direction  )
			return check(x+xPosition,y+yPosition,xPosition,yPosition)

		#x and y co-ordinate of king
		xKing,yKing = king

		#All Eight Direction

		check(xKing,yKing,0,1)
		check(xKing,yKing,0,-1)
		check(xKing,yKing,1,0)
		check(xKing,yKing,-1,0)
		check(xKing,yKing,1,1)
		check(xKing,yKing,-1,-1)
		check(xKing,yKing,-1,1)
		check(xKing,yKing,1,-1)

		# return ans
		return ans

		# Please Upvote if you understand the code..

# def print_list(sample,count):
# 	for i in sample:
# 		if type(i) == list: print_list(i,count + 1)
# 		else: print("---" * count + "+" + str(i))

# sample = [7,[3,2,[1,4]],[5,[6,[2], 3]]]
# print_list(sample,1)


sample = [7,[3,2,[1,4]],[5,[6,[2], 3]]]
answer = 0
# def sum_list(sample):
# 	for i in sample:
# 		if type(i) != list:
# 			global answer
# 			answer += i
# 		else:
# 			sum_list(i)

def sum_list_with_return(sample):
	for i in sample:
		if type(i) != list:
			global answer
			answer += i
		else:
			# print(count)
			sum_list_with_return(i)

# sum_list(sample)
sum_list_with_return(sample)
print (answer) 
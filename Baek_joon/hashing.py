# 백준 15829번 Hashing
L = int(input())
string = input()
M = 1234567891
result = 0

alpha = 'abcdefghijklmnopqrstuvwxyz'
alpha_table = dict()
for i in range(26):
    alpha_table[alpha[i]] = i + 1

for j in range(len(string)):
    result += alpha_table[string[j]] * pow(31, j)
print(result % M)
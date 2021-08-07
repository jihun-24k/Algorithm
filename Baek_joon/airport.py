# 백준 10775번 공항
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

# union find 이론
# 게이트 찾기
def find_gate(gates, plane):
    if gates[plane] != plane:
        gates[plane] = find_gate(gates, gates[plane])
    return gates[plane]
# 합치기
def union_gate(gates, a, b):
    a = find_gate(gates, a)
    b = find_gate(gates, b)
    if a > b:
        gates[a] = b
    else:
        gates[b] = a

G = int(input())
P = int(input())

result = 0
# 게이트 초기화
gates = [0] * (G + 1)
for i in range(1, G + 1):
    gates[i] = i

# 비행기 입력
plane = [0] * (P + 1)
for i in range(1, P + 1):
    plane[i] = int(input())

# 연산 시작
for i in range(1, P + 1):
    docking = find_gate(gates, plane[i])
    if docking != 0:
        union_gate(gates, docking, docking - 1)
        result += 1
    else:
        break
print(result)
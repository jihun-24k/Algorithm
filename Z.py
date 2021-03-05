# 백준 1074번 Z
import sys
input = sys.stdin.readline

N, r, c = map(int,input().split())

# 시간 제약이 많고 메모리는 제약은 작다.
matrix = [[0 for _ in range(2**N+1)] for _ in range(2**N+1)]

print(matrix)

def z_route(x,y,n):
    global N
    # 작은 사각형일 때
    if N == 1:
        matrix[x][y+1] = matrix[x][y] +1    
        matrix[x+1][y] = matrix[x][y+1] +1        
        matrix[x+1][y+1] = matrix[x][y] +1        
        matrix[x][y+1] = matrix[x][y] +1       

    else:
        z_route(x//2,y//2,N//2)
        z_route(x//2,y//2,N//2)
        z_route(x//2,y//2,N//2)
        z_route(x//2,y//2,N//2)

# 하샤드 문제
def sum(x, result):
    if x < 10:
        return result + x
    else:
        return sum(x%10 , result + x//10)

def solution(x):
    is_h = sum(x, 0)
    if x % is_h == 0:
        return True
    else:
        return False
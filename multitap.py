import sys
input = sys.stdin.readline

N, K = map(int, input().split())

array = list(map(int,input().split()))

plug_count = 0
multi_tap = array[:N]
for i in range(N,K):
    # 멀티탭 안에 이미 꽂혀있다면
    if array[i] in multi_tap:
        continue
    # 중복된 코드가 없다면 
    # 코드들의 인덱스를 넣어주는 리스트 선언
    code_idx = []
    # 멀티탭의 코드들을 확인
    for code in multi_tap:
        try:
            idx = array[i:].index(code)
        except:
            idx = 101
        code_idx.append(idx)
    # 빼야하는 코드
    to_out  = code_idx.index(max(code_idx))
    del multi_tap[to_out]
    multi_tap.append(array[i])
    plug_count += 1

print(plug_count)
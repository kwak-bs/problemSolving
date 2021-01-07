# 보물섬
## BOJ_10026번_골5 (두번째 풀이)
- bfs 
- 브루트포스



## 전역 변수

`int y` = 입력. map의 y축

`int x` = 입력. map의 x축

`char map[][]` = 'W'와 'L' 값이 들어갈 이중 배열

`boolean visit[][]` = 방문을 나타내는 이중 배열

`int count[][]` = 각 정점의 bfs 결과값(hour) 저장할 이중 배열

`int dy[]` = y축 이동 (상, 하)

`int dx[]` = x축 이동 (좌, 우)



## 함수

### void main()

y축과 x축을 입력 받습니다. 

map, visit, count 배열을 초기화 하고 map을 입력 받습니다. 

브루트포스로 전 구간을 탐색하며 'L' 값이 있는 구간에 `bfs`를 호출합니다. 

호출한 결과 값( `count[][]`)을 토대로 `countMax()` 함수를 호출합니다. 

각 정점 별로 최댓 값을 비교하고, 전역 변수 `max`에 최댓 값을 저장합니다. 

한 정점을 수행할때마다 `count[][]` 와 `visit[][]`을 초기화합니다.

`max` 출력( 최종 결과 )



### void bfs (int yy, int xx, int cnt)

`void main`에서 `bfs`를 호출할 때 자기 자신은 count 하지 않으므로 초기 `count`값은 무조건 0입니다. 

`q`에는 현재 좌표와 `cnt`(hour)를 저장합니다.

이동할 수 있는 좌표를 탐색한 뒤 `visit`을 체크해주고 `count[][]`의 해당 값을 올려줍니다. 

이동할 수 있는 좌표를 `count[][]` 값과 함께 `q`에 넣어줍니다. 



### int countMax()

각 정점 마다 최단 거리들의 최댓값을 구한 뒤, 

최댓값을 반환합니다. 


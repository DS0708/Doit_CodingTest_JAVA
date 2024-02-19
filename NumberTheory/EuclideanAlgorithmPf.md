# 유클리드 호제법 증명

## 약수의 정의
- a가 0이 아니고 a,b가 정수일때 a가 b의 약수라는 말은 b=ak를 만족하는 정수 k가 존재한다.
- 그렇다면 b가 0일때 k가 0이면 a에는 모든 정수가 들어가도 성립하므로 0의 약수는 모든 정수이다.

## gcd의 정의
- gcd = Greatest Common Divisor
- gcd(3,12) = 3
- gcd란 최대 공약수를 의미

## Setup
- gcd (k,0) = k 이다. (0의 약수는 모든 정수이므로)
- A = Bk + r 일때, gcd(A,B) = gcd(B,r)을 만족한다면 (A는 0이아니고, A>B)
- gcd(A,B)=gcd(B,r1)=gcd(r1,r2)=....=gcd(G,0)=G 이므로 최대 공약수를 구할 수 있음.
- `따라서 gcd(A,B)=gcd(B,r)이 성립함을 보이면 된다.`

## Proof
- A와 B의 최대공약수를 G라고 하면 , A=Ga, B=Gb이고 a와b는 서로소라고 하자.
- A = Bk + r 이고, gcd(A,B)=gcd(B,r)의 의미는 A와B의 최대 공약수와 B와r의 최대 공약수가 같다는 의미
- 위의 식에 대입해보면, Ga = Gbk + r이고 r = G(a-bk)
- B=Gb,r = G(a-bk) 이므로 A와B의 최대 공약수가 G이고 B와 r의 최대공약수가 G이기 위해서는 `b와 (a-bk)가 서로소이면 됨`
- `귀류법 : b와 (a-bk)가 서로소가 아니라면`
- b = mx, a-bk = my인 1이아닌 m이 존재한다.
- a = my + bk -> a = my + mxk -> a = m(y + xk)
- a=m(y+xk), b=mx 이므로  a와 b가 서로소라는 가정이 모순

# 확장 유클리드 호제법 증명
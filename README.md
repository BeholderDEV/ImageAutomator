## Automato

Website images finder

![](https://github.com/BeholderDEV/ImageAutomator/blob/master/Automato%20Imagem.png?raw=true)

## Expressão Regular
```
  ="[a-zA-Z0-9:/.\-_]+\.(jpg|png)"
```
## Gramática

```
S -> =A
A -> "B
B -> L(~. & ~")B | .C
C -> jD | pE | L(~j & ~p & ~")B
D -> pF | L(~p & ~")B
E -> nF | L(~n & ~")B
F -> gI | L(~g & ~")B
I -> " | L(~")B
```



```
S -> ="A
A -> L(~. & ~")B
B -> L(~. & ~")B| .jpg" | .png"
```

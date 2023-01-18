# dummy-json-project
Create automation testing for API dummyjson.com


Cara pindah branch:
```
git checkout feature_a
```

Cara membuat branch baru:
```
git branch feature_b
```


Cara resolve conflict:

- local -> perlu reset commit
  `git reset HEAD~1` (1 commit yg bikin conflict)
- stash perubahan yg di lakukan (perubahan nya itu edit file). kalau perubahan nya file baru. perlu di pindah dulu atau hapus
  `git stash`
- menyamakan current branch dengan main
  `git pull origin main`
- apply perubahan yg udah di stash
  `git stash apply`
- resolve conflict nya
- add perubahan nya
  `git add .`
- commit
  `git commit -m "messagee"`
- push
  `git push origin <branch>`

# NOTE
FORMAT NAMA BRANCH:

- feature/[HTTP METHOD]-[ENDPOINT] contoh:
    - `feature/product`
    - `feature/todos`

FORMAT COMMIT MESSAGE:
- [NAMA BRANCH]: message. contoh:
    - `feature/post-product: Add negative schenario` 


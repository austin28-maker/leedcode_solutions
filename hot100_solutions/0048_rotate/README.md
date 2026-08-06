## 技巧

矩阵转置:matrix[i][j] ↔ matrix[j][i]
矩阵水平镜像:matrix[i][j] ↔ matrix[i][n-1-j]
矩阵垂直镜像:matrix[i][j] ↔ matrix[m-1-i][j]
矩阵顺时针旋转90度， new_matrix[j][n-1-i] = matrix[i][j],就相当于垂直镜像+转置
矩阵顺时针旋转180度，new_matrix[n-1-i][n-1-j] = matrix[i][j],就相当于水平镜像+垂直镜像
矩阵逆时针旋转90度，new_matrix[n-1-j][i] = matrix[i][j],就相当于水平镜像+转置
matrix[:] = [list(row) for row in zip(*matrix[::-1])]
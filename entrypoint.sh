# 切换到工作目录
cd /vcs/work_dir/

# 拷贝 jar包(容器外) 到 work_dir（容器内）
COPY ./target/os-version-1.0-SNAPSHOT.jar  /vcs/work_dir

# 运行java服务 (后台运行)
java -jar os-version-1.0-SNAPSHOT.jar &

# 开启 nginx (前台运行)
nginx -g 'daemon off;'
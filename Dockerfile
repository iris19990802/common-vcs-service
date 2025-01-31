# Base镜像：(java node npm nginx)
FROM lza11111/nginx-java-node:v1
RUN apt install -y git && npm install yarn -g


# ———————————————————————— 构建docker镜像内的目录结构 ————————————————————————
# 根目录
RUN mkdir /vcs && mkdir /vcs/ui && mkdir /vcs/work_dir


# 拉取前端代码
RUN cd /vcs/ui && git clone https://iris19990802:Hdu1020026@github.com/iris19990802/common-vcs-ui

# 编译前端
RUN cd /vcs/ui/common-vcs-ui && yarn && yarn build


# 配置 nginx 
# 拷贝 nginx.conf 到指定目录下
COPY  ./common-vcs-service/nginx.conf   /etc/nginx/conf.d/default.conf


# 拷贝前端运行文件到 nginx
RUN  cp  -r   /vcs/ui/common-vcs-ui/dist/*.*   /usr/share/nginx/html/



EXPOSE 80


# ———————————————————————— 开启nginx、java服务 ————————————————————————

# (容器外->容器内)
COPY ./common-vcs-service/entrypoint.sh /vcs/work_dir/entrypoint.sh
COPY ./common-vcs-service/target/os-version-1.0-SNAPSHOT.jar  /vcs/work_dir

WORKDIR /vcs/work_dir

CMD ["sh","./entrypoint.sh"]

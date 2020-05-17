# Base镜像：(java node npm nginx)
FROM lza11111/nginx-java-node:v1
RUN apt install -y git 
RUN npm install yarn -g


# ———————————————————————— 构建docker镜像内的目录结构 ————————————————————————
# 根目录
RUN mkdir /vcs 
# 源代码
RUN mkdir /vcs/ui
# 工作目录（存放可执行文件）
RUN mkdir /vcs/work_dir



# 拉取前端代码
RUN cd /vcs/ui && git clone https://iris19990802:Hdu1020026@github.com/iris19990802/common-vcs-ui

# 编译前端
RUN cd /vcs/ui/common-vcs-ui && yarn && yarn build


# 配置 nginx 
# 拷贝 nginx.conf 到指定目录下
COPY  /vcs/ui/common-vcs-ui/nginx.conf   /etc/nginx/conf.d/default.conf


# 拷贝前端运行文件到 nginx
RUN  cp  -r   /vcs/ui/common-vcs-ui/dist/   /usr/share/nginx/html/



EXPOSE 80


# ———————————————————————— 开启nginx、java服务 ————————————————————————

COPY /vcs/ui/common-vcs-ui/entrypoint.sh /vcs/work_dir/entrypoint.sh


CMD ["sh","./entrypoint.sh"]







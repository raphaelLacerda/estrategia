FROM node
WORKDIR /app

COPY hello.js .
COPY package.json .

RUN npm install

EXPOSE 3000

CMD ["node", "hello.js"]
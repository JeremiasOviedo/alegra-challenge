FROM node:18.15-alpine

RUN npm install -g http-server

WORKDIR /app/msvc-frontend

COPY ./msvc-frontend/package*.json .

RUN npm install

COPY ./msvc-frontend .

RUN npm run build

EXPOSE 8080
CMD [ "http-server", "dist" ]


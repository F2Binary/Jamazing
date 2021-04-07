ALL:
	javac --module-path /home/a3x3parity/Downloads/javafx-sdk-11.0.2/lib/ --add-modules=javafx.controls -d out HelloWorld.java
	java --module-path /home/a3x3parity/Downloads/javafx-sdk-11.0.2/lib/ --add-modules=javafx.controls -cp out HelloWorld

FAT:
	find /home/a3x3parity/Downloads/javafx-sdk-11.0.2/lib//{javafx.base.jar,javafx.graphics.jar,javafx.controls.java} -exec unzip -nq {} -d out \;
	cp /home/a3x3parity/Downloads/javafx-sdk-11.0.2/lib//{libprism*.so,libjavafx*.so,libglass*.so,libdecora_sse.so} out
	rm out/META-INF/MANIFEST.MF out/module-info.class
	#mkdir libs
	#probably won't need past first run of FAT
	jar --create --file=libs/HelloWorld.jar --main-class=HelloWorld.Launcher -C out .
	java -jar libs/HelloWorld.jar
REM:
	rm -rf out
